package com.nsp.j2ee.liferay.demo.genericportlet;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;

import javax.portlet.*;
import java.io.IOException;
import java.io.PrintWriter;

public class DemoGenericPortlet extends GenericPortlet {
    private static Log _log = LogFactoryUtil.getLog(DemoGenericPortlet.class);

    @Override
    public void init() throws PortletException {
        _log.info("!!!!!!!! This is init method without parameter !!!!!!!!");
        super.init();
    }

    //This method is defined in GenericPortlet
    @Override
    public void init(PortletConfig config) throws PortletException {
        viewTemplate = config.getInitParameter("view-template");
        _log.info("!!!!!!!! Init Parameter of viewTemplate is ==> "+viewTemplate + " !!!!!!!!");
        _log.info("!!!!!!!! This is init method with PortletConfig parameter !!!!!!!!");
        super.init(config);
    }

    @Override
    protected void doView(RenderRequest request, RenderResponse response) throws PortletException,
            IOException {
        _log.info("!!!!!!!! doView invoked !!!!!!!!");
        /*String currentViewPage=request.getParameter("jspPage");
        if(currentViewPage!=null&&!currentViewPage.equals("")){
            include(currentViewPage, request, response);
        }else{
            include(viewTemplate, request, response);
        }*/


        include(viewTemplate, request, response);
//        noJSP(viewTemplate, request, response);
    }

    @ProcessAction(name = "actionMethod1")
    public void processAction1(ActionRequest request, ActionResponse response) throws PortletException, IOException {
        _log.info("!!!!!!!! processAction invoked !!!!!!!!");
        String action = request.getParameter(ActionRequest.ACTION_NAME);
        _log.info("!!!!!!!! Action Name :  " + action +" !!!!!!!!");

//        response.setRenderParameters(request.getParameterMap());
//        response.setRenderParameter("", "");
    }

    @ProcessAction(name = "actionMethod2")
    public void processAction2(ActionRequest request, ActionResponse response) throws PortletException, IOException {
        _log.info("!!!!!!!! processAction invoked !!!!!!!!");
        String action = request.getParameter(ActionRequest.ACTION_NAME);
        _log.info("!!!!!!!! Action Name :  " + action +" !!!!!!!!");

//        response.setRenderParameters(request.getParameterMap());
//        response.setRenderParameter("", "");
    }


    @Override
    public void destroy()  {
        _log.info("!!!!!!!! Destroy invoked !!!!!!!!");
        super.destroy();
    }

    protected void include(
            String path, RenderRequest renderRequest,
            RenderResponse renderResponse)
            throws IOException, PortletException {
        PortletRequestDispatcher portletRequestDispatcher = getPortletContext().getRequestDispatcher(path);

        if (portletRequestDispatcher == null) {
            _log.error("!!!!!!!! " + path + " is not a valid include !!!!!!!!");
        }
        else {
            portletRequestDispatcher.include(renderRequest, renderResponse);
        }
    }

    protected void noJSP(
    String path, RenderRequest renderRequest,
    RenderResponse renderResponse)
            throws IOException, PortletException {
        renderResponse.setContentType("text/html");
        PrintWriter out=renderResponse.getWriter();
        out.print("<b>hello generic portlet from controller</b>");
    }

    protected String viewTemplate;


}
