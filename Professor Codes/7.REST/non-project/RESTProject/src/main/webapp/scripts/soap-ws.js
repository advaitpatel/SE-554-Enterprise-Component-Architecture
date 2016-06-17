/**
 * SOAP request and response handling
 */
$(document).ready(function() {
    var productServiceUrl = 'BootService'; // Preferably write this out from server side

    var soapMessage =
        '<soapenv:Envelope xmlns:soapenv="http://schemas.xmlsoap.org/soap/envelope/" xmlns:boot="http://bootstore.se.cdm.depaul.edu/">\
                <soapenv:Header/>\
                <soapenv:Body>\
                <boot:getBootStyles/>\
                </soapenv:Body>\
                </soapenv:Envelope>';

    $.ajax({
        url: productServiceUrl,
        type: "POST",
        dataType: "xml",
        data: soapMessage,
        success: function(response, text, errorThrown) {
            $('<option value="">&mdash; choose a style &mdash;</option>').appendTo('#bootChooserControl');
            var xml = $(response).find('return').each(function() {
                var productId = $(this).find('productId').text();
                var description = $(this).find('description').text();
                $('<option value="' + productId + '">' + description + '</option>').appendTo('#bootChooserControl');
            })
        },
        error: function(data, text, errorThrown) {
            alert('Load was NOT performed. ');
        },
        complete: function(data) {
        },
        contentType: "text/xml; charset=\"utf-8\""
    });


});
