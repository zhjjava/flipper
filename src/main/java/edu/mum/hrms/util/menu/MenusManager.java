package edu.mum.hrms.util.menu;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.SystemUtils;
import org.apache.log4j.Logger;
import org.exolab.castor.xml.Unmarshaller;

import edu.mum.core.util.CoreConstants;
import edu.mum.hrms.util.LcFrameworkUtil;

public class MenusManager {

    private static Logger log = Logger.getLogger(MenusManager.class);

    private static Menus menus = null;

    public static final String MENU_KEY_IN_SESSION = "svcMenu";

    public static final String TREE_ROOT_NODE_SUFFIX = ".rootNode";

    private static long id = System.currentTimeMillis();

    public static synchronized void loadMenus() throws Exception {
        InputStream is = Menus.class.getResourceAsStream("/xml/menus.xml");        
        InputStreamReader isr = new InputStreamReader(is, CoreConstants.ENCODING_UTF_8);
        menus = new Menus();
        Unmarshaller umar = new Unmarshaller(menus.getClass());
        menus = (Menus) umar.unmarshal(isr);
        Menu[] allmenus = menus.getMenu();
        for (Menu menu : allmenus) {
            postLoad(menu);
        }
    }

    private static void postLoad(Menu menu) {
        menu.setId(String.valueOf(id++));
        Menu[] subMenus = menu.getMenu();
        for (Menu menu2 : subMenus) {
            postLoad(menu2);
        }
    }

    public static Menus getMenus() throws Exception {
        if (menus == null) {
            loadMenus();
        }
        return menus;
    }

	private static Menu copyMenu(Menu menu, String contextPath, Locale locale,
			List<String> operations) {
		String menuOperationCodes = menu.getOperationCodes();
		if(log.isDebugEnabled()){
		   log.debug("@@@copyMenuOperationCodes:" + menuOperationCodes
				+ "," + menu.getLink());
		}
		Menu newMenu=null;
		try {
			if (StringUtils.isNotBlank(menu.getOperationCodes())) {
//				if (operations == null || operations.isEmpty()) {
//					return null;
//				} else {
					menuOperationCodes = menuOperationCodes.toLowerCase();
					String[] mOperationCodes = menuOperationCodes.split(",");
					boolean isFoundOperation = false;
					for (int i = 0; i < mOperationCodes.length; i++) {
						mOperationCodes[i] = mOperationCodes[i].trim();
						if ("all".equals(mOperationCodes[i]) || operations.contains(mOperationCodes[i])) {
							isFoundOperation = true;
						}
						if (isFoundOperation == true) {
							break;
						}
					}
					if (isFoundOperation == false) {
						return null;
					}
//				}
			}
			newMenu = new Menu();
			String link = menu.getLink();
			if (StringUtils.isBlank(link)) {
				link = "#";
			}
			if (StringUtils.isNotBlank(contextPath)) {
				if (link.startsWith("/")) {
					link = contextPath + link;
				}
			}
			newMenu.setId(menu.getId());
			newMenu.setLink(link);
			newMenu.setOrder(menu.getOrder());
			newMenu.setTarget(menu.getTarget());

			if (StringUtils.isNotBlank(menu.getNameKey())) {
				newMenu.setName(LcFrameworkUtil.getI18nMsg(menu.getNameKey(), locale));

			} else {
				newMenu.setName(menu.getName());
			}
			if (StringUtils.isNotBlank(menu.getTitleKey())) {
				newMenu.setTitle(LcFrameworkUtil.getI18nMsg(menu.getNameKey(), locale));
			} else {
				newMenu.setTitle(menu.getTitle());
			}

			Menu[] subMenus = menu.getMenu();
			for (Menu menu2 : subMenus) {
				Menu newSubMenu = copyMenu(menu2, contextPath, locale,
						operations);
				if (newSubMenu != null) {
					newMenu.addMenu(newSubMenu);
				}
			}
			subMenus = newMenu.getMenu();			
			Arrays.sort(subMenus, new MenuComparator());
			newMenu.setMenu(subMenus);
		} catch (IndexOutOfBoundsException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return newMenu;
	}

    public static List<Menu> getMenuByOperations(List<String> operations,
            String contextPath, Locale locale) throws Exception {
        
        Menus allmenus = getMenus();
        List<Menu> menusForOperations = new ArrayList<Menu>();
        Menu[] items = allmenus.getMenu();
        if (StringUtils.isNotBlank(contextPath) && contextPath.endsWith("/")) {
            contextPath = contextPath.substring(0, contextPath.length() - 1);
        }
        
        for (Menu item : items) {
            Menu menu = copyMenu(item, contextPath, locale, operations);
            if (menu != null) {
            	menusForOperations.add(menu);
            }
        }
        
        for(Menu tempMenu:menusForOperations)
        {
        	if(tempMenu.getMenuCount()==1)
        	{
        		Menu subMenu=tempMenu.getMenu(0);
        		tempMenu.setLink(subMenu.getLink());
        		tempMenu.setTarget(subMenu.getTarget());
        		log.debug("getMenuByOperations() - only one submenu:"+tempMenu.getLink()
        				+","+tempMenu.getTarget());
        	}
        }        
        
        
        if (!menusForOperations.isEmpty()) {
            Collections.sort(menusForOperations, new MenuComparator());
            if (log.isDebugEnabled()) {
                log.debug("getMenuByOperations() - menu size:"
                        + menusForOperations.size());
            }
        }
        return menusForOperations;
    }

   

    private static String renderSubTreeNodes(Menu menu, String menuid,
            String node, int index) {
        String menuStr = "";
        if (menu == null) {
            log.warn("renderSubTreeNodes() - Menu is null!");
            return menuStr;
        }

        String mainMenuName = node + index;
        if (node.endsWith(TREE_ROOT_NODE_SUFFIX)) {
            mainMenuName = "menu" + index;
        }
        menuStr += SystemUtils.LINE_SEPARATOR;
        menuStr += mainMenuName + "=" + menuid + ".insFld(" + node + ", "
                + menuid + ".gFld(\"" + menu.getName() + "\", \""
                + menu.getLink() + "\"));";
        Menu[] items = menu.getMenu();
        for (int i = 0; i < items.length; i++) {
            menuStr += renderSubTreeNodes(items[i], menuid, mainMenuName, i);
        }
        return menuStr;
    }

    public static String renderTreeNodes(List<Menu> menus, String menuid) {
        String menuStr = "";
        if (menus == null) {
            log.warn("renderTreeNodes() - menus is null");
            return "";
        }
        int index = 0;
        for (Iterator<Menu> iterator = menus.iterator(); iterator.hasNext();) {
            Menu menu = iterator.next();
            menuStr += renderSubTreeNodes(menu, menuid, menuid
                    + TREE_ROOT_NODE_SUFFIX, index++);
        }

        return menuStr;
    }

    private static void printMenu(Menu menu) {
//        System.out.println("name=" + menu.getName() + ", order="
//                + menu.getOrder() + ", role=" + menu.getRoles());
        Menu[] subs = menu.getMenu();
//        if (subs != null && subs.length != 0) {
//            System.out.println("################ subMenu of " + menu.getName());
//        }
        for (Menu menu2 : subs) {
            printMenu(menu2);
        }
    }
    
    public static void main(String[] args) {
        try {
            //System.out.println(renderTreeNodes(getMenuByRoles(null, "", Locale.getDefault()), "tests"));
        	 Menus allmenus = getMenus();
        	 Menu[] items = allmenus.getMenu();
        	 for (Menu item : items) {
        		 System.out.println(""+item.getNameKey()+","+item.getLink());
             }
            
            
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
    
    
}
