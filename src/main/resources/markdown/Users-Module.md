# Users Module(Manage Users)

* When you click on the **admin** link available on the *header* of the page, Users module is available in the menu .
* This module is available to high level users to manage the users below them.
* This module is accecssible by the following roles and these roles can edit/create/delete corresponding roles :   

1. **Branch Admin Accounts :** Accountant    
2. **BM 0-90 :** Collection Agent, AM 0-90, Manager HFC-SME  
3. **National Head :** Accountant, ACM HT, AM 0-90, BM 0-90, Branch Administrator, Branch Report User, Collection Agent, CRM, HO Accounts, HO-Admin Accounts, HO Report User, Location Head, Manager HFC-SME, Navarang SH, POC Support, RBM 0-90, Repo Agent, RH, SCM 0-90, SR-MIS, Tele Caller 0-30, Tele Caller 0-90, Tele Caller 90+, Tele Caller CV, TL 31-90 Bucket, TL 730+ Bucket, TL 91-730 Bucket, TL Field, TL-Ops, TL-Ops 0-90, TL Report User, TM 0-90, ZH HT, Zonal Acccounts Admin, Zonal Administrator, Zone Report User.
4. **RBM 0-90 :** AM 0-90, BM 0-90, Collection Agent, Manager HFC-SME, Navarang SH, SCM 0-90, TM 0-90, Tele Caller 0-90, TL-OPs 0-90.
5. **Super Administrator :** Has access to all roles.
6. **HO Administrator :** Except Super Administrator accessable to all roles.
7. **HO-Admin Accounts :** Accountant, Cashier, Branch Admin Accounts.
8. **Zonal Administrator :** Accountant, ACM HT, AM 0-90, BM 0-90, Branch Administrator, Branch Report User, Collection Agent, Location Head, Manager HFC-SME, Navarang SH, POC Support, RBM 0-90, Repo Agent, RH, SCM 0-90, SR-MIS, Tele Caller 0-30, Tele Caller 0-90, Tele Caller 90+, Tele Caller CV, TL 31-90 Bucket, TL 730+ Bucket, TL 91-730 Bucket, TL Field, TL-Ops, TL-Ops 0-90, TL Report User, TM 0-90.
9. **Zonal Accountant Admin :** Accountant, Cashier, Branch Admin Accounts.
10. **Branch Administrator :** AM 0-90, BM 0-90, Collection Agent, Manager HFC-SME, Navarang SH, SR-MIS, Tele Caller 0-30, Tele Caller 0-90, Tele Caller CV, TL 31-90 Bucket, TL 730+ Bucket, TL 91-730 Bucket, TL Field, TL-Ops, TL-Ops 0-90, TL Report User.
11. **RH :** ACM HT, AM 0-90, BM 0-90, Branch Administrator, Branch Report User, Collection Agent, Location Head, Manager HFC-SME, Navarang SH, POC Support, RBM 0-90, Repo Agent, RH, SCM 0-90, SR-MIS, Tele Caller 0-30, Tele Caller 0-90, Tele Caller 90+, Tele Caller CV, TL 31-90 Bucket, TL 730+ Bucket, TL 91-730 Bucket, TL Field, TL-Ops, TL-Ops 0-90, TL Report User, TM 0-90.
12. **TM 0-90 :** AM 0-90, BM 0-90, Collection Agent, Location Head, Manager HFC-SME, Navarang SH, SR-MIS, Tele Caller 0-30, Tele Caller 0-90, Tele Caller CV, TL 31-90 Bucket, TL 730+ Bucket, TL 91-730 Bucket, TL Field, TL-Ops, TL-Ops 0-90, TL Report User.
13. **SCM 0-90 :** AM 0-90, BM 0-90, Collection Agent, Location Head, Manager HFC-SME, Navarang SH, SR-MIS, Tele Caller 0-30, Tele Caller 0-90, Tele Caller CV, TL 31-90 Bucket, TL 730+ Bucket, TL 91-730 Bucket, TL Field, TL-Ops, TL-Ops 0-90, TL Report User.
14. **POC Support :** Accessible to all roles except Super-Administrator, HO-Administrator and External Report User.
15. **National F&amp;F :** TL F&F, Regional F&F, Zonal F&F.
16. **Regional F&amp;F :** Collection Agent, Tele Caller 0-90, TL Ops 0-90, AM 0-90, BM 0-90, TL F&F, Manager HFC-SME.
17. **Zonal F&amp;F :** TL F&F, Regional F&F.
18. **TL F&amp;F :** Collection Agent.

---

### Search Filters 

Following are the search filters loaded in the module:

1. **Name** : this filter will take text as input, this will give you the users based on name which has the entered input text.
2. **Ecode** : text as input, this will provide the users with the entered userid.
3. **Role** : dropdown list contains the role names available under the logged-in user to manage, this will provide search based on the roles.
4. **Status** : dropdown list contains the user status, which provides the search based on the current status of the users like "Active,Blocked,Inactive,...".

After entering the search filter inputs, a table-grid will be displayed with the search criterion you provided. Check the screenshot below for reference.

![alt text](https://pocuat.magma.co.in:423/mcmsV3/Documents/images/user-screen-1.png "Users Module when loaded")

![alt text](https://pocuat.magma.co.in:423/mcmsV3/Documents/images/user-screen-2.png "Users Module after inputs")

---

### View User Details 

* After entering a input in the search filter, a table-grid is displayed with the users based on the search filter provided. 
* In that table-grid you will find **action** column at the last, where you can see the view icon   ![alt text](https://pocuat.magma.co.in:8443/magma/images/viewicon.png "View") .
* By clicking the view icon a new page will be displayed, which will show the users details like name, ecode, role, department, etc.. By clicking the back button on the top-right corner you will be redirected to the previous page.

![alt text](https://pocuat.magma.co.in:423/mcmsV3/Documents/images/view-user.png "View User Details")

---

### Delete User 

In the table-grid you will find the delete icon ![alt text](https://pocuat.magma.co.in:8443/magma/images/deleteicon.png "Delete") in the action column, by clicking it that particular user will be deleted i.e the user status is set to INACTIVE .

![alt text](https://pocuat.magma.co.in:423/mcmsV3/Documents/images/delete-user-1.png "Delete User")

![alt text](https://pocuat.magma.co.in:423/mcmsV3/Documents/images/delete-user-2.png "Delete User")

---

### Edit User 

* In the action column, click on the edit icon ![alt text](https://pocuat.magma.co.in:8443/magma/images/editicon.png "Edit") .
* A new page is displayed where you can edit the user's role, territory, branch, locations, module type, etc..
* In edit screen the same functionality of creating new user is applied for each role and after selecting role in the list the options displayed are also same.
* Except this edit screen provides one more option as status, where you can change the status of the user as Active, inactive, blocked, etc...
* Just below the status you'll find a resetpassword checkbox by selecting it'll reset the password of that user to default which is *magma123* .
* After editing click on confirm button to save, else back button to cancel.

---

### Creating New User 

* ![alt text](https://pocuat.magma.co.in:8443/magma/images/createnew_but.jpg "Create New User") icon is available on the top right corner, by clicking it you will be redirected to the user creation page.
* Users who are not assigned to any role are used here to create a new user.

##### Search Filters :

1. **Name** : text as input, this filter will search the un-assigned users with name provided.
2. **Ecode** : text as input, this filter will search the un-assigned users with ecode provided.      

![alt text](https://pocuat.magma.co.in:423/mcmsV3/Documents/images/create-user-1.png "Create New User")
     
* By providing any of the two search filter inputs, a table-grid is diplayed with users available based on the search.
* In action column of the table-grid click on the select icon ![alt text](https://pocuat.magma.co.in:8443/magma/images/select.jpg "Select")  , which will redirect you to another page where you can create the user with your required criteria.
* In the create user page you'll be provided with role, division, location, territory, module-type, etc... inputs by which you can set the user and his working properties.
* click on save button to create the user or else back button to goto the previous page.

check the screenshots for reference

![alt text](https://pocuat.magma.co.in:423/mcmsV3/Documents/images/create-user-2.png "After searching")

![alt text](https://pocuat.magma.co.in:423/mcmsV3/Documents/images/create-user-3.png "When we select user to create")

![alt text](https://pocuat.magma.co.in:423/mcmsV3/Documents/images/create-user-4.png "Editing for roles and other options")


##### Role wise user creation:

* In User creation page based on the role selected we'll get different options below like location, zone, division, etc...
* The following will give you the details on what are shown when a particular role is selected :

**Accountant :** 

* When this role is selected from the role list, **Zone and Territory** drop-downs are shown below the role.
* **Zone** contains static values **NORTH, H.O, SOUTH, EAST, WEST**.
* Based on this selection the **territory** values will be populated based on the **branch-code and zone-code**.
* After selecting a territory from the list, a **Primary branch** drop-down will be shown below the territory, populated based on the **branch code of the selected territory**.
* Once you select the primary branch location, a **Deposit To Locations** multi-select option is shown below to select the deposit locations.
* Select the deposit locations and click on save to create the user.


**ACM HT :**

* When this role is selected from the role list, **Zone, Territory, Divisions and Module-Type** Multi-select grid-box are shown below the role.
* Zone values are provided by joining location_mst and zone_mst tables on the basis of zone code.
*  Based on this selection the **territory** values will be populated based on the **branch-code and zone-code**.
*  After selecting a territory from the list, a **Locations** grid-box will be shown below the territory, populated based on the **branch code of the selected territory**.
*  **Division** grid-box contains the list of divisions(division_mst), in which selected based on the reqirement.
*  **Module-Type** will allow you to select either 0-90 type or 90+ type, to confirm the working bucket of the user to-be created.
*  After selecting required options save the user to create.


**Agency NH :**

* When this role is selected from the role list, **Divisions and Module-Type**  grid-box are shown below the role.
* **Division** grid-box contains the list of divisions(division_mst), in which selected based on the reqirement.
* **Module-Type** will allow you to select either 0-90 type or 90+ type, to confirm the working bucket of the user to-be created.
* After selecting required options save the user to create.


**Agency SH :**

* When this role is selected from the role list, **Zone, Territory, Divisions and Module-Type** Multi-select grid-box are shown below the role.
* Zone values are provided by joining location_mst and zone_mst tables on the basis of zone code.
*  Based on this selection the **territory** values will be populated based on the **branch-code and zone-code**.
*  After selecting a territory from the list, a **Locations** grid-box will be shown below the territory, populated based on the **branch code of the selected territory**.
*  **Division** grid-box contains the list of divisions(division_mst), in which selected based on the reqirement.
*  **Module-Type** will allow you to select either 0-90 type or 90+ type, to confirm the working bucket of the user to-be created.
*  After selecting required options save the user to create.

**Agency ZH :**

* When this role is selected from the role list, **Zone, Territory, Divisions and Module-Type** Multi-select grid-box are shown below the role.
* Zone values are provided by joining location_mst and zone_mst tables on the basis of zone code.
*  Based on this selection the **territory** values will be populated based on the **branch-code and zone-code**.
*  **Division** grid-box contains the list of divisions(division_mst), in which selected based on the reqirement.
*  **Module-Type** will allow you to select either 0-90 type or 90+ type, to confirm the working bucket of the user to-be created.
*  After selecting required options save the user to create.

**AM 0-90 :**

* When this role is selected from the role list, **Zone, Territory and Module-Type**  grid-box are shown below the role.
* Zone values are provided by joining location_mst and zone_mst tables on the basis of zone code.
*  Based on this selection the **territory** values will be populated based on the **branch-code and zone-code**.
*  **Module-Type** will allow you to select either 0-90 type or 90+ type, to confirm the working bucket of the user to-be created.
*  After selecting required options save the user to create.

**BM 0-90 :**

* When this role is selected from the role list, **Zone, Territory, Divisions and Module-Type** Multi-select grid-box are shown below the role.
* Zone values are provided by joining location_mst and zone_mst tables on the basis of zone code.
*  Based on this selection the **territory** values will be populated based on the **branch-code and zone-code**.
*  **Division** grid-box contains the list of divisions(division_mst), in which selected based on the reqirement.
*  **Module-Type** will allow you to select either 0-90 type or 90+ type, to confirm the working bucket of the user to-be created.
*  After selecting required options save the user to create.

**Branch Admin Accounts :**

* When this role is selected from the role list, **Zone and Territory** Multi-select grid-box are shown below the role.
* Zone values are provided by joining location_mst and zone_mst tables on the basis of zone code.
*  Based on this selection the **territory** values will be populated based on the **branch-code and zone-code**.
*  After selecting a territory from the list, **Deposit To Locations and primary branch** grid-box will be shown below the territory, populated based on the **branch code of the selected territory**.
*  After selecting required options save the user to create.

**Branch Administrator :**

* When this role is selected from the role list, **Zone, Territory, Divisions and Module-Type** Multi-select grid-box are shown below the role.
* Zone values are provided by joining location_mst and zone_mst tables on the basis of zone code.
*  Based on this selection the **territory** values will be populated based on the **branch-code and zone-code**.
*  After selecting a territory from the list, a **Locations** grid-box will be shown below the territory, populated based on the **branch code of the selected territory**.
*  **Division** grid-box contains the list of divisions(division_mst), in which selected based on the reqirement.
*  **Module-Type** will allow you to select either 0-90 type or 90+ type, to confirm the working bucket of the user to-be created.
*  After selecting required options save the user to create.

**Branch Report User :**

* When this role is selected from the role list, **Zone and Territory** Multi-select grid-box are shown below the role.
* Zone values are provided by joining location_mst and zone_mst tables on the basis of zone code.
*  Based on this selection the **territory** values will be populated based on the **branch-code and zone-code**.
*  After selecting required options save the user to create.

**Collection Agent :**

* When this role is selected from the role list, **Zone and Territory** drop-downs are shown below the role.
* Zone values are provided by joining location_mst and zone_mst tables on the basis of zone code.
*  Based on this selection the **territory** values will be populated based on the **branch-code and zone-code**.
*  After selecting a territory from the list, **Primary branch** drop-down will be shown below the territory, populated based on the **branch code of the selected territory**.
*  After selecting the primary branch, **Catchment Area and District** are displayed.
*  **Catchment area** values are populated based on the location selected in primary branch (from catchment_area_mst on loc_code).
*  **District** values are populated based on the location selected in the primary branch (from locality_mst, location_state_mst on comp_code, state_code and location_code).
*  After selecting a district value, **Sub-district** grid-box is diplayed to select the sub-districts for the user, which is populated based on the district selected (from locality_mst on comp_code and district_code).
*  After selecting a sub-district, **Pin-codes** grid-box is diplayed which are populated based on the sub-district selected (from locality_mst on comp_code and sub_district_code).
*  After selecting a Pin-code, **Post-office** grid-box is displayed which are populated based on the pin-code selected (from locality_mst on comp_code and pin).
*  After selecting required options save the user to create.

**CRM :**

* CRM is a higher level role, who has access to all activities in all zones and locations, so there is no need of providing options for zone selections, etc.. 
* After selecting CRM from role list, click on save to create the user.

**FI User :**

* When this role is selected from the role list, **Zone and Territory** Multi-select grid-box are shown below the role.
* Zone values are provided by joining location_mst and zone_mst tables on the basis of zone code.
*  Based on this selection the **territory** values will be populated based on the **branch-code and zone-code**.
*  After selecting required options save the user to create.

**HO Accounts :**

* This user role doesn't have any zone or location selection.
* After selecting this role, save the user to create.

**HO Admin Accounts :**

* This user role doesn't have any zone or location selection.
* After selecting this role, save the user to create.

**HO Report User :**

* This user role doesn't have any zone or location selection.
* After selecting this role, save the user to create.

**IAD Report User :**

* This user role doesn't have any zone or location selection.
* After selecting this role, save the user to create.

**Location Head :**

* When this role is selected from the role list, **Zone, Territory, Divisions and Module-Type** Multi-select grid-box are shown below the role.
* Zone values are provided by joining location_mst and zone_mst tables on the basis of zone code.
*  Based on this selection the **territory** values will be populated based on the **branch-code and zone-code**.
*  After selecting a territory from the list, a **Locations** grid-box will be shown below the territory, populated based on the **branch code of the selected territory**.
*  **Division** grid-box contains the list of divisions(division_mst), in which selected based on the reqirement.
*  **Module-Type** will allow you to select either 0-90 type or 90+ type, to confirm the working bucket of the user to-be created.
*  After selecting required options save the user to create.

**Manager HFC-SME :**

* When this role is selected from the role list, **Zone, Territory and Module-Type** Multi-select grid-box are shown below the role.
* Zone values are provided by joining location_mst and zone_mst tables on the basis of zone code.
*  Based on this selection the **territory** values will be populated based on the **branch-code and zone-code**.
*  **Module-Type** will allow you to select either 0-90 type or 90+ type, to confirm the working bucket of the user to-be created.
*  After selecting required options save the user to create.

**National F&F :**

* After selecting this role only **Module-Type** option is displayed.
* Select the bucket you want to assign for the user and save to create.

**National Head :**

* When this role is selected, **Divisions and Module-Type** options are displayed.
* **Division** grid-box contains the list of divisions(division_mst), in which selected based on the reqirement.
* **Module-Type** will allow you to select either 0-90 type or 90+ type, to confirm the working bucket of the user to-be created.
*  After selecting required options save the user to create.

**Navarang SH :**

* When this role is selected from the role list, **Zone, Territory and Module-Type** Multi-select grid-box are shown below the role.
* Zone values are provided by joining location_mst and zone_mst tables on the basis of zone code.
*  Based on this selection the **territory** values will be populated based on the **branch-code and zone-code**.
*  **Module-Type** will allow you to select either 0-90 type or 90+ type, to confirm the working bucket of the user to-be created.
*  After selecting required options save the user to create.

**NH HT :**

* When this role is selected, **Divisions and Module-Type** options are displayed.
* **Division** grid-box contains the list of divisions(division_mst), in which selected based on the reqirement.
* **Module-Type** will allow you to select either 0-90 type or 90+ type, to confirm the working bucket of the user to-be created.
*  After selecting required options save the user to create.

**POC Support :**

* When this role is selected from the role list, **Zone and Territory** Multi-select grid-box are shown below the role.
* Zone values are provided by joining location_mst and zone_mst tables on the basis of zone code.
*  Based on this selection the **territory** values will be populated based on the **branch-code and zone-code**.
*  After selecting required options save the user to create.

**President & CEO - ABF :**

* After selecting this role no options are displayed as this role has higher authority among the roles.
* So directly save it after selecting this role to create.

**RBM 0-90 :**

* When this role is selected from the role list, **Zone, Territory, Divisions and Module-Type** Multi-select grid-box are shown below the role.
* Zone values are provided by joining location_mst and zone_mst tables on the basis of zone code.
*  Based on this selection the **territory** values will be populated based on the **branch-code and zone-code**.
*  After selecting a territory from the list, a **Locations** grid-box will be shown below the territory, populated based on the **branch code of the selected territory**.
*  **Division** grid-box contains the list of divisions(division_mst), in which selected based on the reqirement.
*  **Module-Type** will allow you to select either 0-90 type or 90+ type, to confirm the working bucket of the user to-be created.
*  After selecting required options save the user to create.

**Regional F&F :**

* When this role is selected from the role list, **Zone, Territory and Module-Type** Multi-select grid-box are shown below the role.
* Zone values are provided by joining location_mst and zone_mst tables on the basis of zone code.
*  Based on this selection the **territory** values will be populated based on the **branch-code and zone-code**.
*  **Module-Type** will allow you to select either 0-90 type or 90+ type, to confirm the working bucket of the user to-be created.
*  After selecting required options save the user to create.

**Repo Agent :**

* When this role is selected from the role list, **Zone and Territory** Multi-select grid-box are shown below the role.
* Zone values are provided by joining location_mst and zone_mst tables on the basis of zone code.
*  Based on this selection the **territory** values will be populated based on the **branch-code and zone-code**.
*  After selecting required options save the user to create.

**RH :**

* When this role is selected from the role list, **Zone, Territory, Divisions and Module-Type** Multi-select grid-box are shown below the role.
* Zone values are provided by joining location_mst and zone_mst tables on the basis of zone code.
*  Based on this selection the **territory** values will be populated based on the **branch-code and zone-code**.
*  After selecting a territory from the list, a **Locations** grid-box will be shown below the territory, populated based on the **branch code of the selected territory**.
*  **Division** grid-box contains the list of divisions(division_mst), in which selected based on the reqirement.
*  **Module-Type** will allow you to select either 0-90 type or 90+ type, to confirm the working bucket of the user to-be created.
*  After selecting required options save the user to create.

**SCM 0-90 :**

* When this role is selected from the role list, **Zone, Territory, Divisions and Module-Type** Multi-select grid-box are shown below the role.
* Zone values are provided by joining location_mst and zone_mst tables on the basis of zone code.
*  Based on this selection the **territory** values will be populated based on the **branch-code and zone-code**.
*  After selecting a territory from the list, a **Locations** grid-box will be shown below the territory, populated based on the **branch code of the selected territory**.
*  **Division** grid-box contains the list of divisions(division_mst), in which selected based on the reqirement.
*  **Module-Type** will allow you to select either 0-90 type or 90+ type, to confirm the working bucket of the user to-be created.
*  After selecting required options save the user to create.

**SR-MIS :**

* When this role is selected from the role list, **Zone and Territory** Multi-select grid-box are shown below the role.
* Zone values are provided by joining location_mst and zone_mst tables on the basis of zone code.
*  Based on this selection the **territory** values will be populated based on the **branch-code and zone-code**.
*  After selecting required options save the user to create.

**Tele Caller 0-30 :**

* When this role is selected from the role list, **Zone, Territory and Module-Type** Multi-select grid-box are shown below the role.
* Zone values are provided by joining location_mst and zone_mst tables on the basis of zone code.
*  Based on this selection the **territory** values will be populated based on the **branch-code and zone-code**.
*  **Module-Type** will allow you to select either 0-90 type or 90+ type, to confirm the working bucket of the user to-be created.
*  After selecting required options save the user to create.

**Tele Caller 0-90 :**

* When this role is selected from the role list, **Zone, Territory and Module-Type** drop-downs are shown below the role.
* Zone values are provided by joining location_mst and zone_mst tables on the basis of zone code.
*  Based on this selection the **territory** values will be populated based on the **branch-code and zone-code**.
*  After selecting a territory from the list, **Primary branch** drop-down will be shown below the territory, populated based on the **branch code of the selected territory**.
*  **Module-Type** will allow you to select either 0-90 type or 90+ type, to confirm the working bucket of the user to-be created.
*  After selecting required options save the user to create.

**Tele Caller 90+ :**

* When this role is selected from the role list, **Zone and Territory** drop-downs are shown below the role.
* Zone values are provided by joining location_mst and zone_mst tables on the basis of zone code.
*  Based on this selection the **territory** values will be populated based on the **branch-code and zone-code**.
*  After selecting a territory from the list, **Primary branch** drop-down will be shown below the territory, populated based on the **branch code of the selected territory**.
*  After selecting required options save the user to create.

**Tele Caller CV :**

* When this role is selected from the role list, **Zone, Territory and Module-Type** drop-downs are shown below the role.
* Zone values are provided by joining location_mst and zone_mst tables on the basis of zone code.
*  Based on this selection the **territory** values will be populated based on the **branch-code and zone-code**.
*  **Module-Type** will allow you to select either 0-90 type or 90+ type, to confirm the working bucket of the user to-be created.
*  After selecting required options save the user to create.

**TL 31-90 Bucket :**

* When this role is selected from the role list, **Zone, Territory and Module-Type** drop-downs are shown below the role.
* Zone values are provided by joining location_mst and zone_mst tables on the basis of zone code.
*  Based on this selection the **territory** values will be populated based on the **branch-code and zone-code**.
*  **Module-Type** will allow you to select either 0-90 type or 90+ type, to confirm the working bucket of the user to-be created.
*  After selecting required options save the user to create.

**TL 730+ Bucket :**

* When this role is selected from the role list, **Zone, Territory and Module-Type** drop-downs are shown below the role.
* Zone values are provided by joining location_mst and zone_mst tables on the basis of zone code.
*  Based on this selection the **territory** values will be populated based on the **branch-code and zone-code**.
*  **Module-Type** will allow you to select either 0-90 type or 90+ type, to confirm the working bucket of the user to-be created.
*  After selecting required options save the user to create.

**TL 91-730 Bucket :**

* When this role is selected from the role list, **Zone, Territory and Module-Type** drop-downs are shown below the role.
* Zone values are provided by joining location_mst and zone_mst tables on the basis of zone code.
*  Based on this selection the **territory** values will be populated based on the **branch-code and zone-code**.
*  **Module-Type** will allow you to select either 0-90 type or 90+ type, to confirm the working bucket of the user to-be created.
*  After selecting required options save the user to create.

**TL F&F :**

* When this role is selected from the role list, **Zone, Territory and Module-Type** drop-downs are shown below the role.
* Zone values are provided by joining location_mst and zone_mst tables on the basis of zone code.
*  Based on this selection the **territory** values will be populated based on the **branch-code and zone-code**.
*  **Module-Type** will allow you to select either 0-90 type or 90+ type, to confirm the working bucket of the user to-be created.
*  After selecting required options save the user to create.

**TL Field :**

* When this role is selected from the role list, **Zone, Territory and Module-Type** drop-downs are shown below the role.
* Zone values are provided by joining location_mst and zone_mst tables on the basis of zone code.
*  Based on this selection the **territory** values will be populated based on the **branch-code and zone-code**.
*  **Module-Type** will allow you to select either 0-90 type or 90+ type, to confirm the working bucket of the user to-be created.
*  After selecting required options save the user to create.

**TL-Ops :**

* When this role is selected from the role list, **Zone, Territory and Module-Type** drop-downs are shown below the role.
* Zone values are provided by joining location_mst and zone_mst tables on the basis of zone code.
*  Based on this selection the **territory** values will be populated based on the **branch-code and zone-code**.
*  **Module-Type** will allow you to select either 0-90 type or 90+ type, to confirm the working bucket of the user to-be created.
*  After selecting required options save the user to create.

**TL-Ops 0-90 :**

* When this role is selected from the role list, **Zone, Territory and Module-Type** drop-downs are shown below the role.
* Zone values are provided by joining location_mst and zone_mst tables on the basis of zone code.
*  Based on this selection the **territory** values will be populated based on the **branch-code and zone-code**.
*  **Module-Type** will allow you to select either 0-90 type or 90+ type, to confirm the working bucket of the user to-be created.
*  After selecting required options save the user to create.

**TL Report User :**

* When this role is selected from the role list, **Zone, Territory and Module-Type** drop-downs are shown below the role.
* Zone values are provided by joining location_mst and zone_mst tables on the basis of zone code.
*  Based on this selection the **territory** values will be populated based on the **branch-code and zone-code**.
*  **Module-Type** will allow you to select either 0-90 type or 90+ type, to confirm the working bucket of the user to-be created.
*  After selecting required options save the user to create.

**TM 0-90 :**

* When this role is selected from the role list, **Zone, Territory, Divisions and Module-Type** Multi-select grid-box are shown below the role.
* Zone values are provided by joining location_mst and zone_mst tables on the basis of zone code.
*  Based on this selection the **territory** values will be populated based on the **branch-code and zone-code**.
*  After selecting a territory from the list, a **Locations** grid-box will be shown below the territory, populated based on the **branch code of the selected territory**.
*  **Division** grid-box contains the list of divisions(division_mst), in which selected based on the reqirement.
*  **Module-Type** will allow you to select either 0-90 type or 90+ type, to confirm the working bucket of the user to-be created.
*  After selecting required options save the user to create.

**ZH HT :**

* When this role is selected from the role list, **Zone, Territory, Divisions and Module-Type** Multi-select grid-box are shown below the role.
* Zone values are provided by joining location_mst and zone_mst tables on the basis of zone code.
*  Based on this selection the **territory** values will be populated based on the **branch-code and zone-code**.
*  **Division** grid-box contains the list of divisions(division_mst), in which selected based on the reqirement.
*  **Module-Type** will allow you to select either 0-90 type or 90+ type, to confirm the working bucket of the user to-be created.
*  After selecting required options save the user to create.

**Zonal Accountant Admin :**

* When this role is selected from the role list, **Zone and Territory** Multi-select grid-box are shown below the role.
* Zone values are provided by joining location_mst and zone_mst tables on the basis of zone code.
*  Based on this selection the **territory** values will be populated based on the **branch-code and zone-code**.
*  After selecting required options save the user to create.

**Zonal Administrator :**

* When this role is selected from the role list, **Zone, Territory, Divisions and Module-Type** Multi-select grid-box are shown below the role.
* Zone values are provided by joining location_mst and zone_mst tables on the basis of zone code.
*  Based on this selection the **territory** values will be populated based on the **branch-code and zone-code**.
*  **Division** grid-box contains the list of divisions(division_mst), in which selected based on the reqirement.
*  **Module-Type** will allow you to select either 0-90 type or 90+ type, to confirm the working bucket of the user to-be created.
*  After selecting required options save the user to create.

**Zonal F&F :**

* When this role is selected from the role list, **Zone, Territory and Module-Type** Multi-select grid-box are shown below the role.
* Zone values are provided by joining location_mst and zone_mst tables on the basis of zone code.
*  Based on this selection the **territory** values will be populated based on the **branch-code and zone-code**.
*  **Module-Type** will allow you to select either 0-90 type or 90+ type, to confirm the working bucket of the user to-be created.
*  After selecting required options save the user to create.

**Zone Report User :**

* When this role is selected from the role list, **Zone and Territory** Multi-select grid-box are shown below the role.
* Zone values are provided by joining location_mst and zone_mst tables on the basis of zone code.
*  Based on this selection the **territory** values will be populated based on the **branch-code and zone-code**.
*  After selecting required options save the user to create.


---

> **Developer's Note**     
Files used in the module:    
**Models** : TerminalUserFormBackingObject, EmployeeFormBackingObject.    
**Views** : userList, userCreate, userView, userEdit, terminalEmployeeList.    
**Controllers** : UserListController(Initial load), UserMaintenanceFormController(view,edit,delete), EmployeeListController(create).    
**Author:** Navin Kumar K