var stompClient = null;
$(document).ready(function(){
	$("#received-confirmation").hide();
	$("#sent-confirmation").hide();
});

$(function () {
	$( "form" ).submit(function( event ) {
			event.preventDefault();
  			console.log("button clicked..");
  			$("button[type=submit]").attr("disabled", "disabled");
  			connect();
		}
	);
});

function sendJson(){
	var customerId = $("#customer-id").val();
	var paymentAccountId = $("#payment-account-id").val();
	var paymentAmount = $("#payment-amount").val();
	var productId = $("#product-id").val();
	var quantity = $("#quantity").val();
	var jsonStr = "{" + "\"customerId\":" + customerId + "," + "\"paymentAccountId\":" + paymentAccountId + "," + "\"paymentAmount\":" + paymentAmount + "," + "\"productId\":" + productId + "," + "\"quantity\":" + quantity + "}";
	console.log("Json: \n" + jsonStr);
	stompClient.send("/order/place", {}, jsonStr);			
}

function connect() {
    var socket = new SockJS("/stomp-websocket");
    stompClient = Stomp.over(socket);
    stompClient.connect({}, function (frame) {
        console.log("Connected: " + frame);
        stompClient.subscribe("/topic/order-placed", function (response) {
            console.log("Received response: " + response);
            
			$("#sent-confirmation").hide();
			console.log(response.body);
			var orderConfirmation = JSON.parse(response.body);
			console.log("Order Confirmation ID: "+  orderConfirmation.orderPlacedConfirmationId);
			console.log("Payment Confirmation ID: "+  orderConfirmation.paymentConfirmationId);
			console.log("Dollar amount charged : " + orderConfirmation.dollarAmount);
			var msg = "<strong>Yay!!  </strong> your order was processed successfuly, $" + orderConfirmation.dollarAmount + " was charged to your account<br/> Order Confirmation Number : " + orderConfirmation.orderPlacedConfirmationId + "<br/> Payment Confirmation Number : " + orderConfirmation.paymentConfirmationId;
			$("#received-confirmation").append(msg);
			$("#received-confirmation").show();
        });
        sendJson();
        $("#sent-confirmation").show();
    });
}
