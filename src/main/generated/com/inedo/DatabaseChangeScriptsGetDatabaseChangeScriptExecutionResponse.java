
package com.inedo;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAnyElement;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import org.w3c.dom.Element;


/**
 * <p>Java class for anonymous complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="DatabaseChangeScripts_GetDatabaseChangeScriptExecutionResult" minOccurs="0">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;any processContents='lax' namespace='http://www.w3.org/2001/XMLSchema' maxOccurs="unbounded" minOccurs="0"/>
 *                   &lt;any processContents='lax' namespace='urn:schemas-microsoft-com:xml-diffgram-v1'/>
 *                 &lt;/sequence>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "databaseChangeScriptsGetDatabaseChangeScriptExecutionResult"
})
@XmlRootElement(name = "DatabaseChangeScripts_GetDatabaseChangeScriptExecutionResponse")
public class DatabaseChangeScriptsGetDatabaseChangeScriptExecutionResponse {

    @XmlElement(name = "DatabaseChangeScripts_GetDatabaseChangeScriptExecutionResult")
    protected DatabaseChangeScriptsGetDatabaseChangeScriptExecutionResponse.DatabaseChangeScriptsGetDatabaseChangeScriptExecutionResult databaseChangeScriptsGetDatabaseChangeScriptExecutionResult;

    /**
     * Gets the value of the databaseChangeScriptsGetDatabaseChangeScriptExecutionResult property.
     * 
     * @return
     *     possible object is
     *     {@link DatabaseChangeScriptsGetDatabaseChangeScriptExecutionResponse.DatabaseChangeScriptsGetDatabaseChangeScriptExecutionResult }
     *     
     */
    public DatabaseChangeScriptsGetDatabaseChangeScriptExecutionResponse.DatabaseChangeScriptsGetDatabaseChangeScriptExecutionResult getDatabaseChangeScriptsGetDatabaseChangeScriptExecutionResult() {
        return databaseChangeScriptsGetDatabaseChangeScriptExecutionResult;
    }

    /**
     * Sets the value of the databaseChangeScriptsGetDatabaseChangeScriptExecutionResult property.
     * 
     * @param value
     *     allowed object is
     *     {@link DatabaseChangeScriptsGetDatabaseChangeScriptExecutionResponse.DatabaseChangeScriptsGetDatabaseChangeScriptExecutionResult }
     *     
     */
    public void setDatabaseChangeScriptsGetDatabaseChangeScriptExecutionResult(DatabaseChangeScriptsGetDatabaseChangeScriptExecutionResponse.DatabaseChangeScriptsGetDatabaseChangeScriptExecutionResult value) {
        this.databaseChangeScriptsGetDatabaseChangeScriptExecutionResult = value;
    }


    /**
     * <p>Java class for anonymous complex type.
     * 
     * <p>The following schema fragment specifies the expected content contained within this class.
     * 
     * <pre>
     * &lt;complexType>
     *   &lt;complexContent>
     *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *       &lt;sequence>
     *         &lt;any processContents='lax' namespace='http://www.w3.org/2001/XMLSchema' maxOccurs="unbounded" minOccurs="0"/>
     *         &lt;any processContents='lax' namespace='urn:schemas-microsoft-com:xml-diffgram-v1'/>
     *       &lt;/sequence>
     *     &lt;/restriction>
     *   &lt;/complexContent>
     * &lt;/complexType>
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {
        "anies"
    })
    public static class DatabaseChangeScriptsGetDatabaseChangeScriptExecutionResult {

        @XmlAnyElement
        protected List<Element> anies;

        /**
         * Gets the value of the anies property.
         * 
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the anies property.
         * 
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getAnies().add(newItem);
         * </pre>
         * 
         * 
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link Element }
         * 
         * 
         */
        public List<Element> getAnies() {
            if (anies == null) {
                anies = new ArrayList<Element>();
            }
            return this.anies;
        }

    }

}
