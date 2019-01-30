package com.nsp.j2ee.liferay.leave.rest.extender.application;

import java.util.Collections;
import java.util.List;
import java.util.Set;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Application;
import javax.ws.rs.core.MediaType;

import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.nsp.j2ee.liferay.leave.exception.NoSuchLeaveException;
import com.nsp.j2ee.liferay.leave.model.Leave;
import com.nsp.j2ee.liferay.leave.service.LeaveLocalService;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

@ApplicationPath("/leave-info")
@Component(immediate = true, 	service = Application.class
)
public class LeaveRestApplication extends Application {

	public Set<Object> getSingletons() {
		return Collections.<Object>singleton(this);
	}

	@GET
	@Produces("text/plain")
	public String working() {
		return "It works!  " ;
	}

    @GET
    @Path("/{leaveId}")
    @Produces(MediaType.APPLICATION_JSON)
    public String getLeave(@PathParam("leaveId") long leaveId){
        Leave leave = null;
        String jsonString = null;
        try {
            leave = leaveLocalService.getLeave(leaveId);
            jsonString = JSONFactoryUtil.serialize(leave);
        } catch (Exception e) {
            if(e instanceof NoSuchLeaveException) {
                jsonString = JSONFactoryUtil.serialize("not found");
            }
            e.printStackTrace();
        }
        return jsonString;
    }

    @GET
    @Path("/all")
    @Produces(MediaType.APPLICATION_JSON)
    public String getAllLeaves(){
        List<Leave> leaves = leaveLocalService.getLeaves(-1, -1);
        String jsonString = null;
        try {
            jsonString = JSONFactoryUtil.serialize(leaves);
        } catch (Exception e) {
            if(e instanceof NoSuchLeaveException) {
                jsonString = JSONFactoryUtil.serialize("not found");
            }
            e.printStackTrace();
        }
        return jsonString;
    }

	@GET
	@Path("/morning")
	@Produces("text/plain")
	public String hello() {
		return "Good morning!";
	}

	@GET
	@Path("/morning/{name}")
	@Produces("text/plain")
	public String morning(
		@PathParam("name") String name,
		@QueryParam("drink") String drink) {

		String greeting = "Good Morning " + name;

		if (drink != null) {
			greeting += ". Would you like some " + drink + "?";
		}

		return greeting;
	}
    @Reference(unbind = "-")
    private LeaveLocalService leaveLocalService;

}