<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>SOAP demos</title>
    </head>
    <body>
        Provides for sample wsdl files
            <li><a href="GreeterService?wsdl">Regular Java</a></li>
            <li><a href="ChildGreeterService?wsdl">Inherited Web Service</a></li>
            <li><a href="/GreeterSBService/GreeterSBService?wsdl">Direct SessionBean</a></li>
            <li><a href="GreeterSBProxyService?wsdl">SessionBean Proxy</a></li>
            <li><a href="GreeterSBExtService?wsdl">SessionBean extension</a></li>
            <li><a href="FancyGreeterService?wsdl">Greeter with Req/Resp objects</a></li>
            <li><a href="GreeterImplService?wsdl">GreeterService interface</a></li>
            
            <p>WS-* Example</p>
            <li><a href="LongAwaitedGreetingService?wsdl">Long awaited greeting</a></li>
            <li><a href="AddressedGreeterService?wsdl">Addressing</a></li>
            <li><a href="ReliableGreetingService?wsdl">Reliable Message</a></li>
            <li><a href="BinaryMessage11Service?wsdl">Binary Attachment v1</a></li>
            <li><a href="BinaryMessage12Service?wsdl">Binary Attachment v2</a></li>
    </body>
</html>
