package contracts

import org.springframework.cloud.contract.spec.Contract

Contract.make {

    request {
        method 'GET'
        urlPath '/products/searchbyIds', {
            queryParameters {
                parameter 'productIds': $(consumer(regex('[0-4]{1}')), producer('2'))
            }
        }
    }

    response {
        status 200
        body([
               ["id": 2,
                 "name": "IPHONE",
                 "category": "B",
                 "cost": 35000]
                 
  
        ])
        headers {
            header('Content-Type': value(
                    producer(regex('application/json.*')),
                    consumer('application/json')
            ))
        }
    }
}