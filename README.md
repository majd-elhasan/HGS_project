# HGS System api project

- ![#f03c15](https://via.placeholder.com/15/f03c15/f03c15.png) `In Türkiye : `*HGS*` ,abbr.(turkish : Hızlı Geçiş Sistemi )`
- ![#1589F0](https://via.placeholder.com/15/1589F0/1589F0.png) `like `*E-ZPass*` System in America ,And `*Fastag* `in India`

in this application we can :
- add/fetch/delete tollbooths
- add/fetch/delete vehicles HGS cards (typed as Vehicle)
- fetch records

## The usage of (api)

### ![](https://via.placeholder.com/15/808000/808000.png) Toll Booth
|                     | method | mapping                                                    | path variables                                                  | request parameters         | 
|---------------------|--------|------------------------------------------------------------|-----------------------------------------------------------------|----------------------------|
| get all toll-booths | GET    | */tollBooths*                                              | X                                                               |                            |
| save toll-booth     | POST   | */tollBooths*                                              | X                                                               | X , request body is needed |
| delete toll-booth   | DELETE | */tollBooths*                                              | X                                                               | X , request body is needed |

### ![](https://via.placeholder.com/15/808000/808000.png) Vehicle HGS card
|                           | method | mapping                      | path variables      | request parameters         | 
|---------------------------|--------|------------------------------|---------------------|----------------------------|
| get all vehicles          | GET    | */vehicles*                  | X                   | X                          |
| get vehicle by HGS number | GET    | */vehicles/{**HGS_Number**}* | HGS_Number :int 64  | X                          |
| save vehicle              | POST   | */vehicles*                  | X                   | X , request body is needed |
| delete vehicle HGS card   | DELETE | */vehicles*                  | HGS_Number :int 64  | X                          |

### ![](https://via.placeholder.com/15/808000/808000.png) Records
|                                             | method | mapping                                                | path variables       | request parameters | 
|---------------------------------------------|--------|--------------------------------------------------------|----------------------|--------------------|
| get all records                             | GET    | */records*                                             | X                    | X                  |
| get today's Records                         | GET    | */records/today*                                       | X                    | X                  |
| get all records related to a toll-booth     | GET    | */records/tollBooth_id/{**tollBooth_id**}*             | tollBooth_id :int 64 | X                  |
| get today's Records related to a toll-booth | GET    | */records/tollBooth_id/{**tollBooth_id**}/today*       | tollBooth_id :int 64 | X                  |
| get records by HGS-number                   | GET    | */records/vehicle_HGS/{**HGS_Number**}*                | HGS_Number :int 64   | X                  |
| get today's income                          | GET    | */records/today's_income*                              | X                    | X                  |
| get today's income related to a toll-booth  | GET    | */records/tollBooth_id/{tollBooth_id}/today's_income*  | tollBooth_id :int 64 | X                  |

### ![](https://via.placeholder.com/15/808000/808000.png) Payment ,`the path which the tollbooth is supposed to use`
|                     | method | mapping                                                    | path variables                                                  | request parameters         | 
|---------------------|--------|------------------------------------------------------------|-----------------------------------------------------------------|----------------------------|
| get payment         | GET    | */tollBooths/getPayment/{**tollbooth_id**}/{**HGS_num**}/* | <ul><li>tollbooth_id :int 64</li><li>HGS_num :int 64</li></ul>  | X                          |
