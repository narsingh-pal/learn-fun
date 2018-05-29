package com.nsp.j2ee.liferay.leave.action;


import com.liferay.portal.kernel.portlet.bridges.mvc.BaseMVCActionCommand;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCActionCommand;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.WebKeys;
import com.nsp.j2ee.liferay.leave.constants.LeavePortletKeys;
import com.nsp.j2ee.liferay.leave.model.Leave;
import com.nsp.j2ee.liferay.leave.service.LeaveLocalService;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import java.text.SimpleDateFormat;
import java.util.Date;

@Component(
        property = {
                "javax.portlet.name=" + LeavePortletKeys.Leave,
                "mvc.command.name=leave_updateLeave"
        },
        service = MVCActionCommand.class
)
public class UpdateLeaveActionCommand extends BaseMVCActionCommand {
    static final private Logger logger = LoggerFactory.getLogger(UpdateLeaveActionCommand.class);
    private LeaveLocalService leaveService;
    @Reference(unbind = "-")
    protected void setLeaveService(LeaveLocalService leaveService) {
        this.leaveService = leaveService;
    }

    @Override
    protected void doProcessAction(ActionRequest actionRequest, ActionResponse actionResponse)
            throws Exception {

        logger.info("Process Action Update Invoked !!!!!!");
        String leaveId = ParamUtil.getString(actionRequest, "leaveId");
        Leave leave = leaveService.getLeave(Long.parseLong(leaveId));
        SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
        String name = ParamUtil.getString(actionRequest, "name");
        Date startDate= ParamUtil.getDate(actionRequest, "startDate",sdf );
        Date endDate = ParamUtil.getDate(actionRequest, "endDate", sdf);
        leave.setStartDate(startDate);
        leave.setEndDate(endDate);
        leaveService.updateLeave(leave);
        logger.info("Leave Details updated succcessfully");

    }

}
