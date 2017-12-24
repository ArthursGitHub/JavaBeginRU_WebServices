Генерируем файлы стабы:
wsimport -keep http://localhost:9999/ws/hello?wsdl

Сгенерируются файлы:
interface HelloWorld
class HelloWorldImplService extends Service
