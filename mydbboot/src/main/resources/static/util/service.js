sap.ui.define(["jquery.sap.global"],function(jQuery)
{
return{
	callService : function(sUrl, sMethod, sPayload){
		return new Promise(function(resolve,reject){
			switch(sMethod.toUpperCase()){
				case "GET":
				
				jQuery.ajax(sUrl,{
				type : "GET",
				success : function(data){
					resolve(data);
					
				},
				error : function(err){
					reject(err)
				}
			});
				
				break;
		    case "POST":
		       debugger;
		       jQuery.ajax(sUrl,{
				type : "POST",
				contentType : "application/json", 
				data : JSON.stringify(sPayload),
				success : function(data){
					resolve(data);
					
				},
				error : function(err){
					reject(err)
				}
			});
				
				break;
		    

			}
		});
	}
	
};
}
);