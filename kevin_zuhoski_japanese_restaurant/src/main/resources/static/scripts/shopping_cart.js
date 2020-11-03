let menu_options = [];

let order = {  
  total: [],
  positionValue: 0,
  initMenuItems: function(){
    let me = this;

    //me.loadMenu(1, "menu_entrees");
    //me.loadMenu(2, "menu_beverages");
  },
  loadMenu: function(type, nameClass){
    let menu = menu_options.filter(option => option.itemType==type);
    let htmlMenu = "";
    $.each(menu, function(key, value){
      htmlMenu += "<tr><th scope=\"row\">"+value.itemName+"</th>";
      htmlMenu += "<td>$"+value.itemPrice.toFixed(2)+"</td>";
      htmlMenu += "<td class=\"text-center\">";
      htmlMenu += "<button class=\"btn btn-action\" onclick=\"order.addOrder("+value.menuItemId+")\">ADD</button>&nbsp;&nbsp;";
      htmlMenu += "<button class=\"btn btn-action-remove\" onclick=\"order.removeOrder("+value.menuItemId+")\">REMOVE</button>";
      htmlMenu += "</td></tr>";
    });

    $("#"+nameClass).html(htmlMenu);
  },
  addOrder:function(idMenu){
    let me = this;
    let menuOrder = menu_options.filter(option => option.menuItemId==idMenu);

    let order = menuOrder[0];

    if(order.quantity==0){
      order.quantity = 1;
    }else{
      order.quantity++;
      me.deleteOrder(idMenu);
    }

    if(order.position==0){
      me.positionValue++;
      order.position = me.positionValue;
    }

    me.total.push(order);
    me.listOrderTotal();
  },
  deleteOrder: function(idMenu){
    let me = this;

    var removeIndex = me.total.map(function(item) { return item.menuItemId; }).indexOf(idMenu);
    me.total.splice(removeIndex, 1);

  },
  removeOrder: function(idMenu){
    let me = this;
    let orderObject = me.total.filter(option => option.menuItemId==idMenu);
    let updateIndex = me.total.map(function(item) { return item.menuItemId; }).indexOf(idMenu);

    if(orderObject.length>0){
      if(orderObject[0].quantity==1){
        me.total[updateIndex].quantity = 0;
        me.total[updateIndex].position = 0;
        me.deleteOrder(idMenu);
      }else{
        me.total[updateIndex].quantity--;
      }

      me.listOrderTotal();
    }
  },
  listOrderTotal: function(){
    let me = this;
    $("#menu_total").html("");

    let htmlMenu = "";
    let total = 0;

    me.total.sort(me.compareOrders);

    console.log(me.total);

    $.each(me.total, function(key, value){
      htmlMenu += "<tr><td scope=\"row\">"+value.itemName+"</td>";
      htmlMenu += "<td class=\"text-center\">"+value.quantity+"</td>";
      htmlMenu += "<td class=\"text-right\">$"+value.itemPrice.toFixed(2)+"</td></tr>";
      total += value.itemPrice*value.quantity;
    });

    if(total>0){
      let subTotal = total;
      let tax = (total*0.085);

      htmlMenu += "<tr>";
      htmlMenu += "<th colspan=\"2\">SUB-TOTAL</th>";
      htmlMenu += "<th class=\"text-right\">$"+subTotal.toFixed(2)+"</th>";
      htmlMenu += "</tr>";
      htmlMenu += "<tr>";
      htmlMenu += "<th colspan=\"2\">TAX (8.5%)</th>";
      htmlMenu += "<th class=\"text-right\">$"+tax.toFixed(2)+"</th>";
      htmlMenu += "</tr>";
      htmlMenu += "<tr>";
      htmlMenu += "<th colspan=\"2\">TOTAL</th>";
      htmlMenu += "<th class=\"text-right\">$"+(subTotal + tax).toFixed(2)+"</th>";
      htmlMenu += "</tr>";
      htmlMenu += "<tr>";
      htmlMenu += "<th colspan=\"3\"><button type=\"bottom\" onclick=\"order.sendOrder()\" class=\"btn w-100 btn-action btn-po pt-4 pb-4\">PLACE ORDER</button></th>";
      htmlMenu += "</tr>";
    }

    $("#menu_total").html(htmlMenu);
  },
	  compareOrders: function(a, b) {
	    // Use toUpperCase() to ignore character casing
	    const positionA = a.position;
	    const positionB = b.position;
	
	    let comparison = 0;
	    if (positionA > positionB) {
	      comparison = 1;
	    } else if (positionA < positionB) {
	      comparison = -1;
	    }
	    return comparison;
	  },
	  sendOrder: function(){
		let me = this;
		
		$.ajax({
			url:"/menu-order",
			data: JSON.stringify(me.total),
			contentType: 'application/json',
			type: 'POST',
			dataType: 'json',
			success: function(response){
				if(response.success){
					$("#order-result").html(response.message);
					$("#order-result").addClass("message-success");
				}else{
					$("#order-result").html(response.message);
					$("#order-result").addClass("message-error");
				}
				
			}
		});
	  }

};
