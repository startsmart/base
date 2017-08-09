package startsmart.base.model.general;

/**
 * Created by sanjeev on 08/08/17.
 */
public class StringContent {

    private String content;
    private String contentIgnoreCase;

    /**
     * @param contentParam - String content
     */
    public StringContent(String contentParam)
    {
        if(contentParam == null)
            throw new NullPointerException("String content cannot be null");
        content = contentParam;
    }

    /**
     * @return String content
     */
    public String getContent()
    {
        return this.content;
    }

    /**
     * @return String content in upper case
     */
    protected String getContentIgnoreCase()
    {
        if(contentIgnoreCase == null)
        {
            contentIgnoreCase = content.toUpperCase();
        }
        return contentIgnoreCase;
    }

    /**
     * Returns {@code true} if, and only if, {@link #length()} is {@code 0}.
     * @return {@code true} if {@link #length()} is {@code 0}, otherwise
     * {@code false}
     */
    public boolean isEmpty()
    {
        return this.content.isEmpty();
    }

    /**
     * Returns the length of this string.
     * The length is equal to the number of <a href="Character.html#unicode">Unicode
     * code units</a> in the string.
     *
     * @return  the length of the sequence of characters represented by this
     *          object.
     */
    public int length()
    {
        return this.content.length();
    }

    /**
     * Compares this string content to the specified object.  The result is {@code
     * true} if and only if the argument is not {@code null} and is a {@code
     * StringContent} object that represents the same sequence of characters as this
     * object.
     *
     * @param  other
     *         The object to compare this {@code StringContent} against
     *
     * @return  {@code true} if the given object represents a {@code StringContent}
     *          equivalent to this string, {@code false} otherwise
     */
    public boolean equals(Object other)
    {
        if(other == null) return false;
        if(this == other) return true;
        if(other instanceof StringContent)
        {
            return this.content.equals(((StringContent)other).content);
        }
        if(other instanceof String)
        {
            return this.content.equals(other);
        }
        return false;
    }

    /**
     * Compares this string content to the specified object.  The result is {@code
     * true} if and only if the argument is not {@code null} and is a {@code
     * StringContent} object that represents the same sequence of characters as this
     * object. Based on the ignoreCase flag case sensitivity will be turned on/off
     *
     * @param  other
     *         The object to compare this {@code StringContent} against
     * @param ignoreCase
     * 		  Flag to turn on/off case sensitivity
     *
     * @return  {@code true} if the given object represents a {@code StringContent}
     *          equivalent to this string, {@code false} otherwise
     */
    public boolean equals(Object other, boolean ignoreCase)
    {
        return ignoreCase ? equalsIgnoreCase(other) : equals(other);
    }

    /**
     * Compares this string content to the specified object ignoring the case.  The result is {@code
     * true} if and only if the argument is not {@code null} and is a {@code
     * StringContent} object that represents the same sequence of characters as this
     * object.
     *
     * @param  other
     *         The object to compare this {@code StringContent} against
     * @return  {@code true} if the given object represents a {@code StringContent}
     *          equivalent to this string, {@code false} otherwise
     */
    public boolean equalsIgnoreCase(Object other)
    {
        if(other == null) return false;
        if(this == other) return true;
        if(other instanceof StringContent)
        {
            return this.getContentIgnoreCase().equals(((StringContent)other).getContentIgnoreCase());
        }
        if(other instanceof String)
        {
            return this.getContentIgnoreCase().equals(((String)other).toUpperCase());
        }
        return false;
    }

    /**
     * Returns true if and only if this string content contains the specified
     * sequence of char values.
     *
     * @param s the sequence to search for
     * @return true if this string content contains {@code s}, false otherwise
     */
    public boolean contains(String s)
    {
        return this.content.contains(s);
    }

    /**
     * Returns true if and only if this string content contains the specified
     * sequence of char values.  Based on the ignoreCase flag case sensitivity will be turned on/off
     *
     * @param s the sequence to search for
     * @param ignoreCase
     * 		  Flag to turn on/off case sensitivity
     * @return true if this string content contains {@code s}, false otherwise
     */
    public boolean contains(String s, boolean ignoreCase)
    {
        return ignoreCase ?  containsIgnoreCase(s) : contains(s);
    }

    /**
     * Returns true if and only if this string content contains the specified
     * sequence of char values, ignoring the case.
     *
     * @param s the sequence to search for
     * @return true if this string content contains {@code s}, false otherwise
     */
    public boolean containsIgnoreCase(String s)
    {
        return this.getContentIgnoreCase().contains(s.toUpperCase());
    }

    /**
     * Tests if this string starts with the specified prefix.
     *
     * @param   prefix   the prefix.
     * @return  {@code true} if the character sequence represented by the
     *          argument is a prefix of the character sequence represented by
     *          this string content; {@code false} otherwise.
     *          Note also that {@code true} will be returned if the
     *          argument is an empty string.
     */
    public boolean startsWith(String prefix)
    {
        return this.content.startsWith(prefix);
    }

    /**
     * Tests if this string starts with the specified prefix.
     *
     * @param   prefix   the prefix.
     * @param ignoreCase Flag to turn on/off case sensitivity
     * @return  {@code true} if the character sequence represented by the
     *          argument is a prefix of the character sequence represented by
     *          this string content; {@code false} otherwise.
     *          Note also that {@code true} will be returned if the
     *          argument is an empty string.  Based on the ignoreCase flag case sensitivity will be turned on/off
     */
    public boolean startsWith(String prefix, boolean ignoreCase)
    {
        return ignoreCase ?  startsWithIgnoreCase(prefix) : startsWith(prefix);
    }

    /**
     * Tests if this string starts with the specified prefix, ignoring the case.
     *
     * @param   prefix   the prefix.
     * @return  {@code true} if the character sequence represented by the
     *          argument is a prefix of the character sequence represented by
     *          this string content; {@code false} otherwise.
     *          Note also that {@code true} will be returned if the
     *          argument is an empty string.
     */
    public boolean startsWithIgnoreCase(String prefix)
    {
        return this.getContentIgnoreCase().startsWith(prefix.toUpperCase());
    }

    /**
     * Tests if this string ends with the specified suffix.
     *
     * @param   suffix   the suffix.
     * @return  {@code true} if the character sequence represented by the
     *          argument is a suffix of the character sequence represented by
     *          this object; {@code false} otherwise. Note that the
     *          result will be {@code true} if the argument is the
     *          empty string.
     */
    public boolean endsWith(String suffix)
    {
        return this.content.endsWith(suffix);
    }

    /**
     * Tests if this string ends with the specified suffix. Based on the ignoreCase flag case sensitivity will be turned on/off
     *
     * @param   suffix   the suffix.
     * @param ignoreCase Flag to turn on/off case sensitivity
     * @return  {@code true} if the character sequence represented by the
     *          argument is a suffix of the character sequence represented by
     *          this object; {@code false} otherwise. Note that the
     *          result will be {@code true} if the argument is the
     *          empty string.
     */
    public boolean endsWith(String suffix, boolean ignoreCase)
    {
        return ignoreCase ? endsWithIgnoreCase(suffix) : endsWith(suffix);
    }

    /**
     * Tests if this string ends with the specified suffix, ignoring the case.
     *
     * @param   suffix   the suffix.
     * @return  {@code true} if the character sequence represented by the
     *          argument is a suffix of the character sequence represented by
     *          this object; {@code false} otherwise. Note that the
     *          result will be {@code true} if the argument is the
     *          empty string.
     */
    public boolean endsWithIgnoreCase(String suffix)
    {
        return this.getContentIgnoreCase().endsWith(suffix.toUpperCase());
    }
}
