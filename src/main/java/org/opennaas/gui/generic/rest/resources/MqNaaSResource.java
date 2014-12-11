package org.opennaas.gui.generic.rest.resources;

import java.io.IOException;
import java.util.Collections;
import java.util.Enumeration;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.opennaas.gui.generic.services.JerseyClient;
import org.opennaas.gui.generic.services.RestServiceException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.ResponseBody;

@Component
@Path("/mqnaas")
public class MqNaaSResource {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    protected JerseyClient clientJersey;
   
    @GET
    @Produces(MediaType.APPLICATION_XML)
    @Path("{path}")
    public @ResponseBody void get(@PathParam("path") String path, @Context HttpServletRequest request, @Context HttpServletResponse response) throws IOException, RestServiceException, ServletException {
        this.logger.info("GET() " + path);
        String url = "http://admin:123456@localhost:9000/mqnaas/IRootResourceProvider";
//response.sendRedirect("http://admin:123456@localhost:9000/mqnaas/IRootResourceProvider");
//        response.setStatus(HttpServletResponse.SC_MOVED_PERMANENTLY);
//response.setHeader("Location", "http://admin:123456@localhost:9000/mqnaas/IRootResourceProvider");
//response.flushBuffer();
        logger.info("URI: "+(String) request.getAttribute("uri"));
        HttpServletRequest req = (HttpServletRequest)request;
        request.setAttribute("uri", req.getRequestURI().substring(req.getContextPath().length()));
                     // Forward filtered requests to MyProxy servlet
         request.getRequestDispatcher("/ProxyServlet").forward(request, response);            
        
return;
/*        logger.error(request.getContextPath());
        logger.error(request.getPathInfo());
        logger.error(request.getQueryString());
        logger.error(request.getServletPath());
        logger.error(request.getRequestURI());
        logger.error(request.getRequestURL().toString());
        Enumeration hed = request.getHeaderNames();
        while(hed.hasMoreElements()){
            String keyHeader = (String) hed.nextElement();
            logger.error(keyHeader);
            Enumeration headerValues = request.getHeaders(keyHeader);
            while(headerValues.hasMoreElements()){
                String valueHeader = (String) headerValues.nextElement();
                logger.error(valueHeader);
            }
            List headerValuesList=Collections.list(headerValues);
        }

        String response2 = clientJersey.get(path, request);
        */
        //HttpHeaders hH = req.getHeaders();
//        List<org.springframework.http.MediaType> accept = hH.getAccept();
//        org.springframework.http.MediaType contentType = hH.getContentType();
//        logger.error("Cotnenttype: "+contentType.getType());
//        logger.error("Cotnenttype: "+contentType.getSubtype());
        //return response2;
    }
    /*
    @POST
    @Consumes({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    @Path("{path}")
    public String post(@PathParam("path") String path, HttpRequest req) throws JsonGenerationException, JsonMappingException, IOException, RestServiceException {
        this.logger.info("GET() " + path);
        logger.info("GET METHOD...");
        logger.info(path);
        String response = clientJersey.get(path, req);
        return response;
    }*/
}
