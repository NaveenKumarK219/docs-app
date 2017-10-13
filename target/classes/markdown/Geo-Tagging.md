# Geo Tagging 

### Description

* GeoTagging provides **FOS** transaction data(GPS-Global Positioning System) with location and time on google map.
* Different **Visit Type** color is used to differentiate between different transactions.

This module is available for following roles :

 * HO Administrator
 * Branch Administrator
 * TL F&F
 * Regional F&F
 * Zonal F&F
 * Zonal Administrator
 * National Head
 * AM 0-90
 * BM 0-90
 * TM 0-90
 * SCM 0-90
 * RBM 0-90

### Search Filters

Following are the search filters loaded in the module: 

1. **FOS**: This filter is dropdown list contains the fos names available under the logged-in user, this will provide search based on the FOS   
2. **Visit Type**: This is multiselect dropdown list that contains visit type names,This will provide search and multiselect based on names.     
3. **From Date**: This will take date as input contains only 7 previous days transaction data from the current date shall be available always.     
4. **To Date**: This will take date as input contains only 7 previous days transaction data from the current date shall be available always.    

> **Note**: Differences between from date and to date is 3 days.

**Route Map**: Once we click Route Map check box, then we can check status of FOS based on co-ordinates of date and time.

**Toggle Button**: Once we click on it, provides show or hide visit type colors.

* After searching based on inputs, it'll display the co-ordinates of fos visited in google map.
* When we hover over a map point, then we will get pop up that contains following details  Proposal/Enquiry No,Hirer name,Co Ordinates,Visit Type,Date.


When we click on **Go** button, provided the search inputs we get the following  display

![alt text](https://pocuat.magma.co.in:423/mcmsV3/Documents/images/geotagging1.png "Geo Tagging")

When **Route Map** check box is selected, provided with the search inputs we get the following display

![alt text](https://pocuat.magma.co.in:423/mcmsV3/Documents/images/geotagging2.png "Geo Tagging")

When we hover the mouse Over a **Pointer**, we get the following display

![alt text](https://pocuat.magma.co.in:423/mcmsV3/Documents/images/geotagging3.png "Geo Tagging")

---

> **Developer's Note :**      
Following files used in this module.     
**Models:** FosModuleFormBackingObject    
**Views:** fosViewMap    
**Controllers:** FosViewMapController    
**Author:** Srihari Madapati


