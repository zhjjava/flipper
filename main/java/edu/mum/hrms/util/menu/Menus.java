/*
 * This class was automatically generated with 
 * <a href="http://www.castor.org">Castor 1.3</a>, using an XML
 * Schema.
 * $Id$
 */

package edu.mum.hrms.util.menu;

/**
 * Class Menus.
 * 
 * @version $Revision$ $Date$
 */
@SuppressWarnings("serial")
public class Menus implements java.io.Serializable {


      //--------------------------/
     //- Class/Member Variables -/
    //--------------------------/

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

    public Menus() {
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
     * Method unmarshal.
     * 
     * @param reader
     * @throws org.exolab.castor.xml.MarshalException if object is
     * null or if any SAXException is thrown during marshaling
     * @throws org.exolab.castor.xml.ValidationException if this
     * object is an invalid instance according to the schema
     * @return the unmarshaled edu.mum.hrms.util.menu.Menu
     */
    public static edu.mum.hrms.util.menu.Menus unmarshal(
            final java.io.Reader reader)
    throws org.exolab.castor.xml.MarshalException, org.exolab.castor.xml.ValidationException {
        return (edu.mum.hrms.util.menu.Menus) org.exolab.castor.xml.Unmarshaller.unmarshal(edu.mum.hrms.util.menu.Menus.class, reader);
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
