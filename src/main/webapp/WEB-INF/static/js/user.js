//条件查询
function Search() {
	if($("#userSearchId [name='email']").validatebox("isValid")){
		var queryParameter = $('#allUserId').datagrid("options").queryParams;
	    queryParameter.name = $("#userSearchId [name='name']").val();
	    queryParameter.email = $("#userSearchId [name='email']").val();
	    $("#allUserId").datagrid("reload");
	}else{
		$.messager.alert('警告','请输入有效的电子邮箱地址!','info'); 
	}
}
function addUser() {
	$('#addUserFormId').form('submit', {
	    url: 'doadduser.do',
	    contentType : 'application/json',
//	    dataType : "json",
	    onSubmit: function(param){  //param定义额外的参数
	    	return $(this).form("validate");
	    	/*return $("#addUserId form [name='name']").validatebox("isValid")
	    		&& $("#addUserId form [name='password']").validatebox("isValid")
	    		&& $("#addUserId form [name='sex']").validatebox("isValid")
	    		&& $("#addUserId form [name='level']").validatebox("isValid");*/
	    },
	    success:function(data){
	    	if(!data.msg){
	    		$('#addUserId').window('close');
	    		$("#allUserId").datagrid("reload");
	    	}
	    }    
	});
}
function deleteUsers(){
	var rows = $('#allUserId').datagrid('getSelections');
	if(!rows.length){
		$.messager.alert('警告','请选择删除数据!','info'); 
	}else{
		var userIds = "";
		for(var n = 0 ; n < rows.length ; n++ ){
			userIds += rows[n].id + ","
		}
		userIds = userIds.substring(0,userIds.length-1);
		 $.ajax({
		     type: "POST",
		     url: "deleteusers.do",
		     data: {userIds:userIds},
		     dataType: "json",
		     success: function(data){
		    	 $("#allUserId").datagrid("reload");
		     }
		 });
		
	}
}
function addTabs(title,url){
	if($('#indexTabsId').tabs('exists',title)){
		$('#indexTabsId').tabs('select',title);
	}else{
		$("#indexTabsId").tabs('add',{
		    title:title,
		    closable:true,
		    content: '<div class="easyui-layout" data-options="fit:true">  '+
		        '<div data-options="region:\'center\',href:\' '+url+' \'" ></div>   '+
		        '</div> '
		}); 
	}
}