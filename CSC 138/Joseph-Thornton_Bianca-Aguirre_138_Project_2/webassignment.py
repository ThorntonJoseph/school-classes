#import socket module
from socket import *
serverPort=80
serverSocket = socket(AF_INET, SOCK_STREAM)
#Prepare a sever socket
serverSocket.bind(('',serverPort))
serverSocket.listen(1)
print 'the web server is up on port:',serverPort
while True:
 #Establish the connection
 print 'Ready to serve...'
 connectionSocket, addr = serverSocket.accept()

 try:

    message = connectionSocket.recv(1024)
    print message,'::',message.split()[0],':',message.split()[1]
    filename = message.split()[1]
    print filename,'||',filename[1:]
    f = open(filename[1:])
    outputdata = f.read()
    print outputdata
    #Send one HTTP header line into socket
    #Fill in start
    connectionSocket.send('\nHTTP/1.1 200 OK\n\n')
    connectionSocket.send(outputdata)
     #Fill in end
     #Send the content of the requested file to the client
    for i in range(0, len(outputdata)):
        connectionSocket.send(outputdata[i])
        connectionSocket.close()
 except IOError:
 #Send response message for file not found
    errorfile="error.html"
    f=open(errorfile)
    print "no file found"
    errorout=f.read()
    connectionSocket.send('\nHTTP/1.1 200 OK\n\n')
    connectionSocket.send(errorout)
serverSocket.close();