function profile(){
	var a=document.getElementById("zp_user_information").style.right = 0;
	getProfile();
	
}

function closeProfile(){
	var a=document.getElementById("zp_user_information").style.right =-350;
}

function getProfile()
{
    $.ajax({url: "./ProfileDetails", success: function(result){
	
     var obj = $.parseJSON(result);
setProfileValue(obj);
    }});      
}

 function setProfileValue(obj){
	var name=document.getElementById('userName_h').innerHTML=obj.userName;
	var id=document.getElementById('userId_a').innerHTML=obj.userId;
	var company=document.getElementById('ZPChangeOrg').innerHTML=obj.organization;
    $('#profimg').attr('src',obj.image);
} 
   
 function setFavorites()
{
	
	$.ajax({url: "./FavoritesList", success: function(result){
	
	var sub_ul = $('<ul/>').addClass("sst-edt dash-body Dfav listView").attr("id", "favoritLs");
	$("#favoritLs").replaceWith(sub_ul);
     var obj = $.parseJSON(result);
for(let i=0; i<obj.length; i++){
	createFavorites(obj[i].name,obj[i].empId,obj[i].phone,obj[i].cell,obj[i].image);
}
     
    }});      
}	

function createFavorites(name,emId,mobile,phone,imgpath){
	//var flist=document.getElementById('favoritLs');
	  

	 $("#favoritLs").append("<li>"+"<a><img class='Usrimg FL' src="+imgpath+"></img><div class='ZPUsrDt'><span class='usrDts'><span class='usrEmpID'>"+emId+"-</span>"+name+"</span><span class='sse-mn  IC-mobi'>"+phone+"</span><span class='sse-mn IC-phone'>"+mobile+"</span></div></a>"+"</li>");
     
}

function showNewHiersList(){
	$.ajax({url:"./NewHiers", success:function(response){
		var sub_div=$("<div/>").addClass("dtls").attr("id","newHrs");
		$("#newHrnodata").replaceWith((sub_div));
	    var obj=$.parseJSON(response);
		
		for(let i=0; i<obj.length; i++){
			setNweHiers(obj[i].name,obj[i].userID,obj[i].posting,obj[i].location,obj[i].cell,obj[i].mobile,obj[i].image)
		}
	}});
}

function setNweHiers(name,userid,posting,location,cell,mobile,image){
	$("#newHrs").append("<div class='Uinfo'><div class='Bd-usrimg'><img class='Usrimg' src="+image+"><div cstus='true' uid='-1'></div></div><div class='Udts'><h6 class='CP'><br><span class='usrID'>"+userid+" - </span>"+name+"</br></h6><span>"+posting+"</span><span>"+location+"</span><div class='usr_cl'><span class='MR20'><i class='IC-phone'>"+cell+"</i></span><span class=''><i class='IC-mobi'></i>"+mobile+"</span></div></div></div></div>");
}


function showUpcomingHolidays(){
	var sub_list=$("<ul/>").addClass("hdaylist dash-body").attr('id','holiListu');
	
	$.ajax({url:"./Holidays",success:function(response){
		
        $('#holiListul').replaceWith(sub_list);
		var HdayObj=$.parseJSON(response);
		
		for(let i=0; i<HdayObj.length;i++){
		  setHolidayList(HdayObj[i].Hdayname,HdayObj[i].date,HdayObj[i].day,HdayObj[i].type);
		}
		
	}})
	
  
}
 
 function setHolidayList(HdayName,date,day,type){
   $('#holiListu').append("<li class='hdaydiv'><div class='hdname MT8'>"+HdayName+"<span>"+type+"</span></div><div class='hdate'>"+date+"<span>"+day+"</span></div></li>");
 
 }
 
 function showFileDetails(){
 showQuickLinks();
   $.ajax({url:"./OrganizationFiles", success:function(response){
       var orgFileObj=$.parseJSON(response);
       var fileList=$("<ul/>").addClass("filelist tab-pane active").attr('id','orgFile').attr('onscroll','FILECABINET.getMoreFiles()');
       $("#orgF").replaceWith(fileList);
       
       for(let i=0; i<orgFileObj.length; i++){
       setOrganizationFile(orgFileObj[i].fileName,orgFileObj[i].fileType);
       }
       console.log(orgFileObj);
   }})
 }
 
 function setOrganizationFile(fileName,fileType){
    if(fileType=="pdf"){
    $("#orgFile").append("<li class='listFiles'><a><i class='IC-pdf MR5'></i>"+fileName+"</a></li>");
    }
    if(fileType=="word"){
    $("#orgFile").append("<li class='listFiles'><a><i class='IC-wd MR5'></i>"+fileName+"</a></li>")
    }
 }
 
 
 function showQuickLinks(){
   $.ajax({url:"./QuickLinks", success(response){
   
      var linkUl=$("<ul/>").addClass("Qklinks dash-body").attr('id','linkId');
      $("#linkQ").replaceWith(linkUl);
     var linkObj= $.parseJSON(response);
      console.log(linkObj);
      
      for(let i=0; i<linkObj.length; i++){
      setQuiclkLink(linkObj[i].linkname,linkObj[i].url);
      }
   }})
 }
 
 function setQuiclkLink(linkName,linkUrl){
 $("#linkId").append("<li><a href="+linkUrl+"><i class='Qkicon CR-link'><i class='path1'></i><i class='path2'></i></i>"+linkName+"</a></li>");
 }
