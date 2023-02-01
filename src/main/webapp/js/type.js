/**
 * 
 */
 //---------删除类别

 function deleteType(typename,count){
	swal({
		title:"",
		text:"您确认要删除改类别吗?",
		 icon: "warning",
		  buttons: true,
		  dangerMode: true
	})
	.then((willDelete)=>{
		if(willDelete){
		
			$.ajax({
			type:"post",
			url:"notetypedelete.do",
			data:{
				typename:typename,
				count:count
			},
			success:function(result){
				//判断是否删除成功
				if(result.code==1){
					swal("",""+result.msg+"","success");
					deleteDom(count);
					
				}else{
					swal("",""+result.msg+"","error");
					
				}
			}
		});
		
		}
		else{
			swal("取消删除操作");
			location.reload();
		}
		
		
		
	});
		
	
}
function deleteDom(count){
	var mytable=document.getElementById("myTable");
	var trlength=$("#myTable tr").length;
	if(trlength==2){
		$("#myTable").remove();
		$("#tablediv").html("<h3>未查询到类别信息</h3>");
		
	}else{
		$("#tr_"+count).remove();
		location.reload();
	}
	$("li_"+count).remove();
	location.reload();
	
}
/*
*关闭模态框
*/
$("#close").click(function(){
	$("#myModal").modal("hide");
});
/*
*打开添加模态框
*/
$("#addBtn").click(function(){
	$("#myModalLabel").html("新增类别");
	$("#myModal").modal("show");
	//清空模态框
	$("#modalname").val("");
	$("#modalId").val("");
	
	$("#modalCount").val("");
	$("#msg").html("");
});
/*
*打开修改模态框
*/
function openUpdateDialog(typename,typeid,count){
	$("#myModalLabel").html("修改类别");
	//得到当前选择的类别
	//id选择器，获取选中tr
	//var tr=$("#tr_"+typename);
	console.log(typename);
	$("#msg").html("");
	$("#modalname").val(typename);
	$("#modalId").val(typeid);
	$("#modalCount").val(count);
	$("#myModal").modal("show");
}

$("#btn_submit").click(function(){
	//获取参数
	var typename=$("#modalname").val();
	var typeid=$("#modalId").val();
	var count=$("#modalCount").val();
	if(typename==null){
		$("#msg").html("类别名称不能为空!");
		return;
	}
	$.ajax({
		type:"post",
		url:"typeaddormodify.do",
		data:{
			typename:typename,
			typeid:typeid
		},
		success:function(result){
			if(result.code==1){
				//关闭模态框
				$("#myModal").modal("hide");
				if(typeid==null){
					//添加操作
					//addtypeDom(typename,count+1,result.code);
					location.reload();
				}else{
					//updateDom(typename,count);
					location.reload();
				}
			}
			else{
				$("#msg").html(result.msg);
			}
		}
	})
});

/*
*修改同步DOM
*/
function updateDom(typename,count){
	var tr=$("#tr_"+count);
	tr.children().eq(1).text(typename);
	//左侧类别修改
	$("#sp_"+count).html(typename);
}
function addtypeDom(typename,count,code){
	
	var tr='<tr id="tr_'+count+'"><td>'+count+'</td><td>'+typename+'</td>';
	tr+='<td><button class="btn btn-warning" type="button" onclick="openUpdateDialog('+typename+','+code+','+count+')">修改</button>';
	tr+='<button class="btn btn-danger del" type="button" onclick="deleteType('+typename+','+count+')" >删除</button></td> </tr>'	;	
								
	var table=$("#myTable");	
	table.append(tr);					
}
