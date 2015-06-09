<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
  <xsl:output method="html" encoding="UTF-8"/>
  <xsl:template match="/">
  	<p>
   		<xsl:apply-templates select="Param/cell" mode="title"/>
   	</p>
  </xsl:template>
   	 <xsl:template match="cell" mode="title">
    	<div>
    	<span>
    		<xsl:value-of select="@caption"/>
    	</span>
    	<a>
            <xsl:apply-templates select="cell" mode="small"/>
        </a>
        </div>
     </xsl:template>
     <xsl:template match="cell" mode="small">
   	  <table>
   	  <tr>
  
   	  <td>
    	<p>	
    		<xsl:attribute name="onclick">
          		<xsl:value-of select="@action"/>
        	</xsl:attribute>
        	<img align="left" style="margin-right:3px" width="16" height="16">
          <xsl:attribute name="src">
            <xsl:value-of select="@imgsrc"/>
          </xsl:attribute>
          <xsl:attribute name="alt">
            <xsl:value-of select="@alt"/>
          </xsl:attribute>
        </img>
        	<xsl:value-of select="@caption"/>
    		</p>
    		</td>
    	</tr>
    	</table>
    	
    </xsl:template>
</xsl:stylesheet>
