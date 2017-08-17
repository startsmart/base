package startsmart.base.utility.web;

import startsmart.base.constant.StringConstants;
import startsmart.base.utility.text.EscapeUtil;

import java.util.List;
import java.util.regex.Pattern;

/**
 * Created by sanjeev on 16/08/17.
 */
public final class HTMLHelper {

    public static final String TITLE_XPATH = "./head/title";
    public static final String BODY_XPATH = "./body";
    public static final String ALL_SCRIPT_XPATH = "//script";

    public static final String SCRIPT_TAG_REGEX = "\\<script.*?/\\s*script>";
    public static final String STYLE_TAG_REGEX = "\\<style.*?/\\s*style>";
    public static final String MARKUP_REGEX = "\\<.*?>";


    private static final Pattern MARKUP_PATTERN = Pattern.compile(MARKUP_REGEX, Pattern.CASE_INSENSITIVE);
    private static final Pattern STYLE_TAG_PATTERN = Pattern.compile(STYLE_TAG_REGEX, Pattern.CASE_INSENSITIVE);
    private static final Pattern SCRIPT_TAG_PATTERN = Pattern.compile(SCRIPT_TAG_REGEX, Pattern.CASE_INSENSITIVE);


    private HTMLHelper(){

    }

    public static String getPageTitle(String page){
        //TODO
        return null;
    }

    public static String safeGetPageTitle(String page){
        //TODO
        return null;
    }

    public static Object getTitleTag(String page){
        //TODO
        return null;
    }

    public static String getBodyContent(String page){
        //TODO
        return null;
    }

    public static String safeGetBodyContent(String page){
        //TODO
        return null;
    }

    public static Object getBodyTag(String page) {
        //TODO
        return null;
    }

    public static String getScriptContent(String page){
        //TODO
        return null;
    }
    public static String safeGetScriptContent(String page){
        //TODO
        return null;
    }

    public static List<String> getAllScriptContent(String page ){
        //TODO
        return null;
    }

    public static List<?> getAllScriptTags(String page){
        //TODO
        return null;
    }

    public static String stripHTML(String page)
    {
        if(page == null || page.isEmpty()) return page;
        String noHtml = STYLE_TAG_PATTERN.matcher(cleanHTMLContent(page)).replaceAll(StringConstants.SPACE);
        noHtml = SCRIPT_TAG_PATTERN.matcher(noHtml).replaceAll(StringConstants.SPACE);
        noHtml = MARKUP_PATTERN.matcher(noHtml).replaceAll(StringConstants.SPACE);
        return noHtml;
    }

    public static String stripMarkups(String page)
    {
        if(page == null || page.isEmpty()) return page;
        String noTag = MARKUP_PATTERN.matcher(cleanHTMLContent(page)).replaceAll(StringConstants.SPACE);
        return noTag;
    }

    public static String cleanHTMLContent(String content)
    {
        if(content == null || content.isEmpty()) return content;
        String cleanHtml = content.trim().replaceAll("\\s", StringConstants.SPACE).replaceAll(" +", StringConstants.SPACE);
        cleanHtml = EscapeUtil.unescapeHtml(cleanHtml);
        return cleanHtml;
    }

    private static String stripAndClean(String content)
    {
        return cleanHTMLContent(stripHTML(content));
    }

    private static String stripMarkupAndClean(String content)
    {
        return cleanHTMLContent(stripMarkups(content));
    }

    private static List<?> getHTMLContent(String page, String xpath)
    {
        return null;
    }

}
