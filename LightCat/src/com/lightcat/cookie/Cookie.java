package com.lightcat.cookie;
import java.io.Serializable;
import java.text.MessageFormat;
import java.util.ResourceBundle;

public class Cookie
    implements Cloneable, Serializable
{

    public Cookie(String name, String value)
    {
        maxAge = -1;
        version = 0;
        isHttpOnly = false;
        if(name == null || name.length() == 0)
            throw new IllegalArgumentException(lStrings.getString("err.cookie_name_blank"));
        if(!isToken(name) || name.equalsIgnoreCase("Comment") || name.equalsIgnoreCase("Discard") || name.equalsIgnoreCase("Domain") || name.equalsIgnoreCase("Expires") || name.equalsIgnoreCase("Max-Age") || name.equalsIgnoreCase("Path") || name.equalsIgnoreCase("Secure") || name.equalsIgnoreCase("Version") || name.startsWith("$"))
        {
            String errMsg = lStrings.getString("err.cookie_name_is_token");
            Object errArgs[] = new Object[1];
            errArgs[0] = name;
            errMsg = MessageFormat.format(errMsg, errArgs);
            throw new IllegalArgumentException(errMsg);
        } else
        {
            this.name = name;
            this.value = value;
            return;
        }
    }

    public void setComment(String purpose)
    {
        comment = purpose;
    }

    public String getComment()
    {
        return comment;
    }

    public void setDomain(String domain)
    {
        this.domain = domain.toLowerCase();
    }

    public String getDomain()
    {
        return domain;
    }

    public void setMaxAge(int expiry)
    {
        maxAge = expiry;
    }

    public int getMaxAge()
    {
        return maxAge;
    }

    public void setPath(String uri)
    {
        path = uri;
    }

    public String getPath()
    {
        return path;
    }

    public void setSecure(boolean flag)
    {
        secure = flag;
    }

    public boolean getSecure()
    {
        return secure;
    }

    public String getName()
    {
        return name;
    }

    public void setValue(String newValue)
    {
        value = newValue;
    }

    public String getValue()
    {
        return value;
    }

    public int getVersion()
    {
        return version;
    }

    public void setVersion(int v)
    {
        version = v;
    }

    private boolean isToken(String value)
    {
        int len = value.length();
        for(int i = 0; i < len; i++)
        {
            char c = value.charAt(i);
            if(c < ' ' || c >= '\177' || TSPECIALS.indexOf(c) != -1)
                return false;
        }

        return true;
    }

    public Object clone()
    {
        try
        {
            return super.clone();
        }
        catch(CloneNotSupportedException e)
        {
            throw new RuntimeException(e.getMessage());
        }
    }

    public void setHttpOnly(boolean isHttpOnly)
    {
        this.isHttpOnly = isHttpOnly;
    }

    public boolean isHttpOnly()
    {
        return isHttpOnly;
    }

    private static final long serialVersionUID = -6454587001725327448L;
    private static final String TSPECIALS;
    private static final String LSTRING_FILE = "javax.servlet.http.LocalStrings";
    private static ResourceBundle lStrings = ResourceBundle.getBundle("javax.servlet.http.LocalStrings");
    private String name;
    private String value;
    private String comment;
    private String domain;
    private int maxAge;
    private String path;
    private boolean secure;
    private int version;
    private boolean isHttpOnly;

    static 
    {
        if(Boolean.valueOf(System.getProperty("org.glassfish.web.rfc2109_cookie_names_enforced", "true")).booleanValue())
            TSPECIALS = "/()<>@,;:\\\"[]?={} \t";
        else
            TSPECIALS = ",; ";
    }
}
