<?xml version="1.0" encoding="ISO-8859-1"?>
<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">

    <xsl:template match="/Decathlon">
        <html>
            <head>
                 <title>Decathlon Result</title>
                <link rel="stylesheet" type="text/css" href="style.css"/>
        </head>

            <body>
                <div class="main-container">
                <div class="center-container">
                <table class="table-style">
                    <tr>
                        <th>Place</th>
                        <th>Name</th>
                        <th>Score</th>
                    </tr>
                        <xsl:for-each select="Result">
                            <tr>
                                <td><xsl:value-of select="Place"/></td>
                                <td><xsl:value-of select="Name" /></td>
                                <td><xsl:value-of select="Score" /></td>
                            </tr>
                         </xsl:for-each>
                </table>
                </div>
                </div>
            </body>
        </html>
    </xsl:template>

</xsl:stylesheet>