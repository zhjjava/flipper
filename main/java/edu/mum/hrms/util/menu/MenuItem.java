/*
 * This class was automatically generated with 
 * <a href="http://www.castor.org">Castor 1.3</a>, using an XML
 * Schema.
 * $Id$
 */

package edu.mum.hrms.util.menu;

/**
 * Class MenuItem.
 * 
 * @version $Revision$ $Date$
 */
@SuppressWarnings("serial")
public class MenuItem implements java.io.Serializable {


      //--------------------------/
     //- Class/Member Variables -/
    //--------------------------/

    /**
     * Field _id.
     */
    private java.lang.String _id;

    /**
     * Field _nameKey.
     */
    private java.lang.String _nameKey;

    /**
     * Field _name.
     */
    private java.lang.String _name;

    /**
     * Field _link.
     */
    private java.lang.String _link;

    /**
     * Field _script.
     */
    private java.lang.String _script;

    /**
     * Field _target.
     */
    private java.lang.String _target;

    /**
     * Field _titleKey.
     */
    private java.lang.String _titleKey;

    /**
     * Field _title.
     */
    private java.lang.String _title;

    /**
     * Field _operationCodes.
     */
    private java.lang.String _operationCodes;

    /**
     * Field _order.
     */
    private int _order = 0;

    /**
     * keeps track of state for field: _order
     */
    private boolean _has_order;

    /**
     * internal content storage
     */
    private java.lang.String _content = "";

    /**
     * Field _menuList.
     */
    private java.util.Vector<edu.mum.hrms.util.menu.Menu> _menuList;


      //----------------/
     //- Constructors -/
    //----------------/

    public MenuItem() {
        super();
        setContent("");
        this._menuList = new java.util.Vector<edu.mum.hrms.util.menu.Menu>();
    }


      //-----------/
     //- Methods -/
    //-----------/

    /**
     * 
     * 
     * @param vMenu
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     */
    public void addMenu(
            final edu.mum.hrms.util.menu.Menu vMenu)
    throws java.lang.IndexOutOfBoundsException {
        this._menuList.addElement(vMenu);
    }

    /**
     * 
     * 
     * @param index
     * @param vMenu
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     */
    public void addMenu(
            final int index,
            final edu.mum.hrms.util.menu.Menu vMenu)
    throws java.lang.IndexOutOfBoundsException {
        this._menuList.add(index, vMenu);
    }

    /**
     */
    public void deleteOrder(
    ) {
        this._has_order= false;
    }

    /**
     * Method enumerateMenu.
     * 
     * @return an Enumeration over all
     * edu.mum.hrms.util.menu.Menu elements
     */
    public java.util.Enumeration<? extends edu.mum.hrms.util.menu.Menu> enumerateMenu(
    ) {
        return this._menuList.elements();
    }

    /**
     * Returns the value of field 'content'. The field 'content'
     * has the following description: internal content storage
     * 
     * @return the value of field 'Content'.
     */
    public java.lang.String getContent(
    ) {
        return this._content;
    }

    /**
     * Returns the value of field 'id'.
     * 
     * @return the value of field 'Id'.
     */
    public java.lang.String getId(
    ) {
        return this._id;
    }

    /**
     * Returns the value of field 'link'.
     * 
     * @return the value of field 'Link'.
     */
    public java.lang.String getLink(
    ) {
        return this._link;
    }

    /**
     * Method getMenu.
     * 
     * @param index
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     * @return the value of the
     * edu.mum.hrms.util.menu.Menu at the given index
     */
    public edu.mum.hrms.util.menu.Menu getMenu(
            final int index)
    throws java.lang.IndexOutOfBoundsException {
        // check bounds for index
        if (index < 0 || index >= this._menuList.size()) {
            throw new IndexOutOfBoundsException("getMenu: Index value '" + index + "' not in range [0.." + (this._menuList.size() - 1) + "]");
        }

        return (edu.mum.hrms.util.menu.Menu) _menuList.get(index);
    }

    /**
     * Method getMenu.Returns the contents of the collection in an
     * Array.  <p>Note:  Just in case the collection contents are
     * changing in another thread, we pass a 0-length Array of the
     * correct type into the API call.  This way we <i>know</i>
     * that the Array returned is of exactly the correct length.
     * 
     * @return this collection as an Array
     */
    public edu.mum.hrms.util.menu.Menu[] getMenu(
    ) {
        edu.mum.hrms.util.menu.Menu[] array = new edu.mum.hrms.util.menu.Menu[0];
        return (edu.mum.hrms.util.menu.Menu[]) this._menuList.toArray(array);
    }

    /**
     * Method getMenuCount.
     * 
     * @return the size of this collection
     */
    public int getMenuCount(
    ) {
        return this._menuList.size();
    }

    /**
     * Returns the value of field 'name'.
     * 
     * @return the value of field 'Name'.
     */
    public java.lang.String getName(
    ) {
        return this._name;
    }

    /**
     * Returns the value of field 'nameKey'.
     * 
     * @return the value of field 'NameKey'.
     */
    public java.lang.String getNameKey(
    ) {
        return this._nameKey;
    }

    /**
     * Returns the value of field 'operationCodes'.
     * 
     * @return the value of field 'OperationCodes'.
     */
    public java.lang.String getOperationCodes(
    ) {
        return this._operationCodes;
    }

    /**
     * Returns the value of field 'order'.
     * 
     * @return the value of field 'Order'.
     */
    public int getOrder(
    ) {
        return this._order;
    }

    /**
     * Returns the value of field 'script'.
     * 
     * @return the value of field 'Script'.
     */
    public java.lang.String getScript(
    ) {
        return this._script;
    }

    /**
     * Returns the value of field 'target'.
     * 
     * @return the value of field 'Target'.
     */
    public java.lang.String getTarget(
    ) {
        return this._target;
    }

    /**
     * Returns the value of field 'title'.
     * 
     * @return the value of field 'Title'.
     */
    public java.lang.String getTitle(
    ) {
        return this._title;
    }

    /**
     * Returns the value of field 'titleKey'.
     * 
     * @return the value of field 'TitleKey'.
     */
    public java.lang.String getTitleKey(
    ) {
        return this._titleKey;
    }

    /**
     * Method hasOrder.
     * 
     * @return true if at least one Order has been added
     */
    public boolean hasOrder(
    ) {
        return this._has_order;
    }

    /**
     * Method isValid.
     * 
     * @return true if this object is valid according to the schema
     */
    public boolean isValid(
    ) {
        try {
            validate();
        } catch (org.exolab.castor.xml.ValidationException vex) {
            return false;
        }
        return true;
    }

    /**
     * 
     * 
     * @param out
     * @throws org.exolab.castor.xml.MarshalException if object is
     * null or if any SAXException is thrown during marshaling
     * @throws org.exolab.castor.xml.ValidationException if this
     * object is an invalid instance according to the schema
     */
    public void marshal(
            final java.io.Writer out)
    throws org.exolab.castor.xml.MarshalException, org.exolab.castor.xml.ValidationException {
        org.exolab.castor.xml.Marshaller.marshal(this, out);
    }

    /**
     * 
     * 
     * @param handler
     * @throws java.io.IOException if an IOException occurs during
     * marshaling
     * @throws org.exolab.castor.xml.ValidationException if this
     * object is an invalid instance according to the schema
     * @throws org.exolab.castor.xml.MarshalException if object is
     * null or if any SAXException is thrown during marshaling
     */
    public void marshal(
            final org.xml.sax.ContentHandler handler)
    throws java.io.IOException, org.exolab.castor.xml.MarshalException, org.exolab.castor.xml.ValidationException {
        org.exolab.castor.xml.Marshaller.marshal(this, handler);
    }

    /**
     */
    public void removeAllMenu(
    ) {
        this._menuList.clear();
    }

    /**
     * Method removeMenu.
     * 
     * @param vMenu
     * @return true if the object was removed from the collection.
     */
    public boolean removeMenu(
            final edu.mum.hrms.util.menu.Menu vMenu) {
        boolean removed = _menuList.remove(vMenu);
        return removed;
    }

    /**
     * Method removeMenuAt.
     * 
     * @param index
     * @return the element removed from the collection
     */
    public edu.mum.hrms.util.menu.Menu removeMenuAt(
            final int index) {
        java.lang.Object obj = this._menuList.remove(index);
        return (edu.mum.hrms.util.menu.Menu) obj;
    }

    /**
     * Sets the value of field 'content'. The field 'content' has
     * the following description: internal content storage
     * 
     * @param content the value of field 'content'.
     */
    public void setContent(
            final java.lang.String content) {
        this._content = content;
    }

    /**
     * Sets the value of field 'id'.
     * 
     * @param id the value of field 'id'.
     */
    public void setId(
            final java.lang.String id) {
        this._id = id;
    }

    /**
     * Sets the value of field 'link'.
     * 
     * @param link the value of field 'link'.
     */
    public void setLink(
            final java.lang.String link) {
        this._link = link;
    }

    /**
     * 
     * 
     * @param index
     * @param vMenu
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     */
    public void setMenu(
            final int index,
            final edu.mum.hrms.util.menu.Menu vMenu)
    throws java.lang.IndexOutOfBoundsException {
        // check bounds for index
        if (index < 0 || index >= this._menuList.size()) {
            throw new IndexOutOfBoundsException("setMenu: Index value '" + index + "' not in range [0.." + (this._menuList.size() - 1) + "]");
        }

        this._menuList.set(index, vMenu);
    }

    /**
     * 
     * 
     * @param vMenuArray
     */
    public void setMenu(
            final edu.mum.hrms.util.menu.Menu[] vMenuArray) {
        //-- copy array
        _menuList.clear();

        for (int i = 0; i < vMenuArray.length; i++) {
                this._menuList.add(vMenuArray[i]);
        }
    }

    /**
     * Sets the value of field 'name'.
     * 
     * @param name the value of field 'name'.
     */
    public void setName(
            final java.lang.String name) {
        this._name = name;
    }

    /**
     * Sets the value of field 'nameKey'.
     * 
     * @param nameKey the value of field 'nameKey'.
     */
    public void setNameKey(
            final java.lang.String nameKey) {
        this._nameKey = nameKey;
    }

    /**
     * Sets the value of field 'operationCodes'.
     * 
     * @param operationCodes the value of field 'operationCodes'.
     */
    public void setOperationCodes(
            final java.lang.String operationCodes) {
        this._operationCodes = operationCodes;
    }

    /**
     * Sets the value of field 'order'.
     * 
     * @param order the value of field 'order'.
     */
    public void setOrder(
            final int order) {
        this._order = order;
        this._has_order = true;
    }

    /**
     * Sets the value of field 'script'.
     * 
     * @param script the value of field 'script'.
     */
    public void setScript(
            final java.lang.String script) {
        this._script = script;
    }

    /**
     * Sets the value of field 'target'.
     * 
     * @param target the value of field 'target'.
     */
    public void setTarget(
            final java.lang.String target) {
        this._target = target;
    }

    /**
     * Sets the value of field 'title'.
     * 
     * @param title the value of field 'title'.
     */
    public void setTitle(
            final java.lang.String title) {
        this._title = title;
    }

    /**
     * Sets the value of field 'titleKey'.
     * 
     * @param titleKey the value of field 'titleKey'.
     */
    public void setTitleKey(
            final java.lang.String titleKey) {
        this._titleKey = titleKey;
    }

    /**
     * Method unmarshal.
     * 
     * @param reader
     * @throws org.exolab.castor.xml.MarshalException if object is
     * null or if any SAXException is thrown during marshaling
     * @throws org.exolab.castor.xml.ValidationException if this
     * object is an invalid instance according to the schema
     * @return the unmarshaled
     * edu.mum.hrms.util.menu.MenuItem
     */
    public static edu.mum.hrms.util.menu.MenuItem unmarshal(
            final java.io.Reader reader)
    throws org.exolab.castor.xml.MarshalException, org.exolab.castor.xml.ValidationException {
        return (edu.mum.hrms.util.menu.MenuItem) org.exolab.castor.xml.Unmarshaller.unmarshal(edu.mum.hrms.util.menu.MenuItem.class, reader);
    }

    /**
     * 
     * 
     * @throws org.exolab.castor.xml.ValidationException if this
     * object is an invalid instance according to the schema
     */
    public void validate(
    )
    throws org.exolab.castor.xml.ValidationException {
        org.exolab.castor.xml.Validator validator = new org.exolab.castor.xml.Validator();
        validator.validate(this);
    }

}
