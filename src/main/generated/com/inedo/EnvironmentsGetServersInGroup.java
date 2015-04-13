
package com.inedo;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


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
 *         &lt;element name="apiKey" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="ServerGroup_Server_Id" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="IncludeInactive_Indicator" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
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
    "apiKey",
    "serverGroupServerId",
    "includeInactiveIndicator"
})
@XmlRootElement(name = "Environments_GetServersInGroup")
public class EnvironmentsGetServersInGroup {

    protected String apiKey;
    @XmlElement(name = "ServerGroup_Server_Id", required = true, type = Integer.class, nillable = true)
    protected Integer serverGroupServerId;
    @XmlElement(name = "IncludeInactive_Indicator")
    protected String includeInactiveIndicator;

    /**
     * Gets the value of the apiKey property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getApiKey() {
        return apiKey;
    }

    /**
     * Sets the value of the apiKey property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setApiKey(String value) {
        this.apiKey = value;
    }

    /**
     * Gets the value of the serverGroupServerId property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getServerGroupServerId() {
        return serverGroupServerId;
    }

    /**
     * Sets the value of the serverGroupServerId property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setServerGroupServerId(Integer value) {
        this.serverGroupServerId = value;
    }

    /**
     * Gets the value of the includeInactiveIndicator property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getIncludeInactiveIndicator() {
        return includeInactiveIndicator;
    }

    /**
     * Sets the value of the includeInactiveIndicator property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setIncludeInactiveIndicator(String value) {
        this.includeInactiveIndicator = value;
    }

}
