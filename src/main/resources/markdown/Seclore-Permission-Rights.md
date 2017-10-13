# Seclore Permission Rights

---

### Description

This module is available to HO Administrator to manage seclore rights of the dynamic reports for different roles.

---

### Search Filters 
Following are the search filters loaded in the module:

1. **Roles** : Different roles that can generate dynamic reports.
2. **Reports** : Dynamic reports for the selected role.

---

### View Dynamic Report Details 
* After selecting search filters, a table-grid is displayed with the dynamic reports based on the search filters provided. 
* Each Dynamic report has view, Lite view, Edit, Copy Data, Print, Screen Capture, Macro, Full Control access rights.

| perm_name      | perm_value |
| -------------- | ---------- |
| view           |          2 |
| edit           |         34 |
| Copy data      |        258 |
| print          |         10 |
| screen capture |        514 |
| macro          |       1026 |
| full control   |        170 |
| lite viewer    |          6 |

* According to selection of check boxes in above columns access rights in Final value of the grid will change.
* Four buttons Enable,Disable,Select All,Reset are there at the bottom of the grid.
* On Clicking "Select All" button all checkboxes in action column will be selected.
* On Clicking "Reset" button all checkboxes in action column will be un selected.

---

### SAVE Button
* If we click on 'SAVE' button value in final column of the report will be updated in access_rights column in seclore_role_rights table.

### Enable button
* After selecting one (or) multiple check boxes in action column when we click on enable button Seclore Permission Rights are applied on selected dynamic reports.After enabling you can see active column is changed to 'Yes' of those selected dynamic reports.

### Disable button
*  After selecting one (or) multiple check boxes in action column when we click on disable button Seclore Permission Rights will not be applied on selected dynamic reports.After disabling you can see active column is changed to 'No' of those selected dynamic reports.

### Access Sharing
* Each dynmaic report has Access sharing column which contains a checkbox, After selecting the check box and click the save button,access_sharing column value of the table seclore_role_rights changed to 'true' to that dynamic report. If we un-select the check box and click save button respective value changed to 'false'.

---

> **Developer's Note**     
Files used in the module:     
**Models** : SecloreFormBackingObject.     
**Views** : secloreList.     
**Controllers** : secloreListController(Initial load).     
**Author:** Vijay Kumar Reddy