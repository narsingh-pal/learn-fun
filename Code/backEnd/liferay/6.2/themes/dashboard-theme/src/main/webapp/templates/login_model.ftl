<div class="modal fade in" id="loginPopup" role="dialog" style="display: none;">
			  <div class="modal-dialog" role="document">
			    <div class="modal-content">
			      <div class="modal-header">
			        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
			        <h4 class="modal-title" id="myModalLabel">Login</h4>
			      </div>
			      <div class="modal-body">
					  <#assign VOID = freeMarkerPortletPreferences.setValue('display-style', '1') />
					  <#assign VOID = freeMarkerPortletPreferences.setValue('portlet-setup-show-borders', 'false') />
					  <#assign instanceId = 'E3j7' />
					  <#assign myPortletId = '58_INSTANCE_'+instanceId />
					  <#assign myPortletId = '58' />
					  ${theme.runtime(myPortletId,'',freeMarkerPortletPreferences.toString())}
					  <#assign VOID = freeMarkerPortletPreferences.reset() />
			      </div>
			      <div class="modal-footer">
			        <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
			      </div>
			    </div>
			  </div>
			</div>