---

---

Current Abilities
-----------------
  * Write a story using "AdventureScript" . Or whatever you want to call the emerging file type.    
  * Load a human readable / writeable adventure file. The adventure file
is formatted to be easy to read and write, for anyone with a text editor. The first word of the first line of a new section in the file names the place or area you describe in the following lines before the ###. The next words on first line, separated by spaces indicate the places this area or section connects too. This first line is all the information that is needed to build the adjaceny list for the graph that controls the underlying structure of the adventure.  
  * There's a Rudimentary system for parsing commands, blocking If I'm understanding things correctly.  It would be nice to change this.  
  * Navigating from section to section by typing the location name EXACTLY.   
  * Each section has a description which is displayed using "look".  
  * Display current location and reachable locations by typing "where".  
  * Display a status with health armor and magic by typing "status".  
  * Look at the inventory with the command "inv".  
  * Use items from inventory.  
  * Rudiments of an inventory system. add and remove items.  
  * Extend Item to make items for use.This needs work
  * Nodes can be created with items in them from the adventurescript file.

ToDo
-----
  * Make item usage make sense. 
  * Ability to "take" / "drop"  items from locations.
  * More ability to control reachable locations. ie add and remove edges from the graph.  
  * Items at locations.  
  * NPCs at locations.  
  * Some rudimentary interaction for NPC’s and items.   
  * Ability to add “paths” and items to locations through item/location/npc interactions.  
  * Better display for inventory  
  * Ability to add / remove / use items from inventory.  
  * A battle( Damage or repair, hit or miss) some armor or class system. Randomization.  
  * System for making choices.
