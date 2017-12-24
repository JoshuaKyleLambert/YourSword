---

---

Current Abilities
-----------------
  * Write a story using "AdventureScript".    
  * Load a human readable / writeable adventure file.  
  * The adventure file is formatted to be easy to read and write for anyone with a text editor. The first word of the first line, of a new section in the file, names the place or area you will describe in the following lines (those before the ###). The next words on first line, separated by spaces, indicate the locations this area or section connects too. This first line is all the information that is needed to build the adjaceny list for the graph that controls the underlying structure of the adventure.  
  * There's a rudimentary system for parsing commands, which may cause blocking. It would be nice to alter this.  
  * Navigating from section to section by typing the location name EXACTLY.   
  * Each section has a description which is displayed using "look".  
  * Display current location and reachable locations by typing "where".  
  * Display a status with health armor and magic by typing "status".  
  * Look at the inventory with the command "inv".  
  * Use items from inventory.  
  * Rudiments of an inventory system allowing the addition and removal of items.  
  * Extend item to make items available for use (this feature still needs some work).
  * Nodes can be created with items in them from the adventurescript file.
  * Can now "take" items from a location node and place them in inventory.

To Do
-----
  * Make item usage make sense. 
  * Ability to "drop"  items from locations.
  * More ability to control reachable locations (ie add and remove edges from the graph).
  * NPCs at locations.  
  * Some rudimentary interaction for NPC’s and items.   
  * Ability to add “paths” and items to locations through item/location/npc interactions.  
  * Better display for inventory  
  * Ability to add / remove items from inventory.  
  * A battle (damage or repair, hit or miss) as well as some armor, class system, or randomization.  
  * System for making choices.
  * A parent Entity class might be needed.
