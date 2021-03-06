'use strict';

services.factory('TestMqNaaSService', ['$http', 'x2js', 'HistoryService', function ($http, x2js, HistoryService) {
        console.log("GET Test MqNaaS");
        return {
            get: function () {
                var promise = $http.get('rest/mqnaas/IRootResourceProvider').then(function (response) {
                    // convert the data to JSON and provide
                    // it to the success function below
                    //var x2js = new X2JS();
                    var json = x2js.xml_str2json(response.data);
                    var his = new HistoryService();
                    his.content = "Jojojo";
                    his.type = "INFO";
                    his.$save(function (data) {console.log(data);});
                    return json;
                }
                );
                return promise;
            }
        };
    }]);
