/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/7.0.47
 * Generated at: 2018-08-02 14:25:24 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.WEB_002dINF.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class login_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  private javax.el.ExpressionFactory _el_expressionfactory;
  private org.apache.tomcat.InstanceManager _jsp_instancemanager;

  public java.util.Map<java.lang.String,java.lang.Long> getDependants() {
    return _jspx_dependants;
  }

  public void _jspInit() {
    _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
    _jsp_instancemanager = org.apache.jasper.runtime.InstanceManagerFactory.getInstanceManager(getServletConfig());
  }

  public void _jspDestroy() {
  }

  public void _jspService(final javax.servlet.http.HttpServletRequest request, final javax.servlet.http.HttpServletResponse response)
        throws java.io.IOException, javax.servlet.ServletException {

    final javax.servlet.jsp.PageContext pageContext;
    javax.servlet.http.HttpSession session = null;
    final javax.servlet.ServletContext application;
    final javax.servlet.ServletConfig config;
    javax.servlet.jsp.JspWriter out = null;
    final java.lang.Object page = this;
    javax.servlet.jsp.JspWriter _jspx_out = null;
    javax.servlet.jsp.PageContext _jspx_page_context = null;


    try {
      response.setContentType("text/html; charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write("\r\n");
      out.write("<!DOCTYPE html>\r\n");
      out.write("<html>\r\n");
      out.write("\t<head>\r\n");
      out.write("\t\t<meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\r\n");
      out.write("\t\t<title>欢迎登陆</title>\r\n");
      out.write("\t\t<style type=\"text/css\">\r\n");
      out.write("\t\t\tbody{\r\n");
      out.write("\t\t\t\tmin-height: 300px;\r\n");
      out.write("\t\t\t\tmin-width: 500px;\r\n");
      out.write("\t\t\t\tbackground-color: #eee;\r\n");
      out.write("\t\t\t}\r\n");
      out.write("\t\t\t.loginClass{\r\n");
      out.write("\t\t\t\tborder: 1px solid #000;\r\n");
      out.write("\t\t\t\twidth: 500px;\r\n");
      out.write("\t\t\t\theight: 300px;\r\n");
      out.write("\t\t\t\tmargin: auto;\r\n");
      out.write("\t\t\t\tmargin-top: 7%;\r\n");
      out.write("\t\t\t\tbackground-color: #fff;\r\n");
      out.write("\t\t\t}\r\n");
      out.write("\t\t\t.loginClass > div {\r\n");
      out.write("\t\t\t\ttext-align: center;\r\n");
      out.write("\t\t\t\twidth: 70%;\r\n");
      out.write("\t\t\t\tmargin: auto;\r\n");
      out.write("\t\t\t\tmargin-top: 20px;\r\n");
      out.write("\t\t\t\tmin-height: 32px;\r\n");
      out.write("\t\t\t\tfont-size: 20px;\r\n");
      out.write("\t\t\t}\r\n");
      out.write("\t\t\t.loginClass input{\r\n");
      out.write("\t\t\t\theight: 18px;\r\n");
      out.write("\t\t\t}\r\n");
      out.write("\t\t\t#loginId{\r\n");
      out.write("\t\t\t\twidth: 70%;\r\n");
      out.write("\t\t\t\theight: 36px;\r\n");
      out.write("\t\t\t}\r\n");
      out.write("\t\t</style>\r\n");
      out.write("\t</head>\r\n");
      out.write("\t<body>\r\n");
      out.write("\t\t<form action=\"login.do\" method=\"post\">\r\n");
      out.write("\t\t\t<div class=\"loginClass\">\r\n");
      out.write("\t\t\t\t<div><h2>登陆</h2></div>\r\n");
      out.write("\t\t\t\t<div>\r\n");
      out.write("\t\t\t\t\t<label>用户：</label>\r\n");
      out.write("\t\t\t\t\t<input type=\"text\" name=\"username\" />\r\n");
      out.write("\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t<div>\r\n");
      out.write("\t\t\t\t\t<label>密码：</label>\r\n");
      out.write("\t\t\t\t\t<input type=\"password\" name=\"password\"/>\r\n");
      out.write("\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t<div>\r\n");
      out.write("\t\t\t\t\t<input type=\"submit\" value=\"登陆\" id=\"loginId\"/>\r\n");
      out.write("\t\t\t\t</div>\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t</form>\r\n");
      out.write("\t</body>\r\n");
      out.write("\t<script type=\"text/javascript\">\r\n");
      out.write("\t\twindow.onload=function (){\r\n");
      out.write("\t\t    var error=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${error}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("\";\r\n");
      out.write("\t\t\tif(error){\r\n");
      out.write("\t\t\t\talert(error);\r\n");
      out.write("\t\t\t}\r\n");
      out.write("\t\t}\r\n");
      out.write("\t</script>\r\n");
      out.write("</html>");
    } catch (java.lang.Throwable t) {
      if (!(t instanceof javax.servlet.jsp.SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try { out.clearBuffer(); } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}