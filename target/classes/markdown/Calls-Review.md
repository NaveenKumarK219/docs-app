# Calls Review

* Calls Review module is used to **review the calls made by Tele-caller**.
* This module gives the review of all calls done by a Tele-caller in a range of dates.
* This module is only used to view the calls made and see the call details.
* The module is available to the following roles :

1. TL-OPS 0-90  
2. Regional F&F

-----------------------------------------------------------------------------

### Search Filters

Following are the list of search filters available for the module :

1. **Proposal No:** text as input, this filter will give the results on the proposal no provided in the filter.
2. **TC:** Drop-down select, containing the Tele-caller Ecodes. Based on allocation this filter is populated. With this calls made by a particular TC can be observed.
3. **FOS:** Drop-down select, with FOS ecodes based on the allocation. This provides the calls allocated to a particular FOS.
4. **Opng Bucket:** Drop-down select, contains the buckets for searching the calls based on the bucket values. This filter is populated from hb_0_30_proposals based on level allocation of the user.
5. **Call Type:** Drop-down select, contains the call types i.e type of call made by the TC. This is select-static with values as **Precall, FI call, Follow Up call, Welcome Call and Other call**, which gives the results based on the type of the call made.
6. **Visit Type:** Drop-down select, contains the visit types. This filter is populated from the visit_type_mst table and gives the results based on the type of visit done by FOS.
7. **Call Purpose:** Drop-down select, contains the Call purpose values, obtained from call_disposition_mst table. This results the calls based on the purpose of the call made.
8. **Disposition Code:** Drop-down select, contains the disposition codes. This filter is populated from call_disposition_mst table, which gives the results based on the disposition code of the call made.
9. **List Type:** Drop-down select, contains static values **EMI, ODI, NR and Self Assigned**. This results the calls made from the selected list types.
10. **Sub Type:** Drop-down select, contains static values **Precall, Follow Up, Bounce, Campaign, Added by Caller**. Which gives the results on the selected sub type of calls.
11. **Risk Category:** Drop-down select, contains the risk category values obtained from risk_category_mst table. This will give the results with the calls made with the selected risk category value.
12. **From Date:** Date in the Format DD MMM, YYYY (Ex: 19 Sep, 2017). This filter will give the calls made from the mentioned date.
13. **TO Date:** Date in the Format DD MMM, YYYY. This filter provides the calls made to that particular date.

> **NOTE** : From date and To date filters work parallely to give the calls in between the dates.

Refer the screenshot below for the module view after selecting a filter and search.

![alt text](https://pocuat.magma.co.in:423/mcmsV3/Documents/images/calls-review-1.png "Calls Review Initial screen")

![alt text](https://pocuat.magma.co.in:423/mcmsV3/Documents/images/calls-review-2.png "Calls Review after filter inputs")

-----------------------------------------------------------------------------

### View Call Details

* After providing the filter inputs, the table-grid is populated with the calls made between the from and to date ranges with the selected filters.
* In the Table-grid, ![alt text](https://pocuat.magma.co.in:8443/magma/images/viewicon.png "VIEW") view button is available in the action column, by clicking it you will be redirected to the call details page where you can see the particular calls details.

![alt text](https://pocuat.magma.co.in:423/mcmsV3/Documents/images/call-details.png "Calls Details View Page")

------------------------------------------------------------------------------

### Calls Review Functionality Role-wise

* Calls review module is available to **TL-OPS and Regional F&F** only.
* Working functionality and logic is same for both the roles, the only difference is the data population of TC and FOS filters.
* **For TL-OPS**, the two filters are populated from **hb_0_30_users** table based on the allocation i.e for TC it is level2_code based on Tl-Ops level5_code and for FOS it is level1_code based on tl-ops level5_code.
* **For Regional F&F**, the two filters are populated by joining  **regional_ff_tlops_mapping_mst and hb_0_30_users** tables i.e first we will get the Tl-Ops ecodes that are mapped to regional-ff and then we will get the TC/FOS under each TL-Ops mapped to regional-ff.

-----------------------------------------------------------------------------------

> **Developers Note :**  
Files used in the module :    
**Models:** CallSummaryFormBackingObject   
**Views:** callList030, callsDetailsView     
**Controllers:** CallList030Controller, CallSummary030MaintenanceFormController    
**Author:** Navin Kumar K
