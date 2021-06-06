# Hardermode

Hardermode is my first Minecraft plugin.
The motivation behind it is to make the game
harder, but without making it unfair.
My point here is not have mobs killing you in a
single hit and spawning them on two blocks away
from you.

I want to keep the main gameplay just make it
more challenging, that will make the player
search for better armors and weapons. My main
goal is actually create the *midgame* aspect
that minecraft, in my opinion, lacks.

## Gameplay

Some gameplay aspects changed:

- Players can take damage 50% faster after take 
  damage.

## Mobs

Every mob categorized as [monster](https://hub.spigotmc.org/javadocs/spigot/org/bukkit/entity/Monster.html)
will spawn with different status from Vanilla:

- 30% maximum health increased;
- 25% base damage increased;
- 50% arrow cooldown reduction;

### Creeper

[Creeper](https://minecraft.fandom.com/wiki/Creeper)
explosions will destroy a shield if a
player blocks the explosion.

### Illusioner

Whenever a non-spellcaster [Illager](https://minecraft.fandom.com/wiki/Illager)
spawns, there is a 10% chance to spawn a
[Illusioner](https://minecraft.fandom.com/wiki/Illusioner)
instead.

### Skeleton

Skeletons (except stray) have a 15% change to spawn with one
[tipped arrow](https://minecraft.fandom.com/wiki/Arrow#Tipped_arrows)
among 4:

- Arrow of Decay (which applies wither effect);
- Arrow of Harming;
- Arrow of Poison;
- Arrow of Weakness

If a skeleton spawn with any of those arrows,
he will drop it when killed.

### Stray

[Stray](https://minecraft.fandom.com/wiki/Stray)
received a buff, whenever it hits a player
with an arrow, and the player is already with [slowness](https://minecraft.fandom.com/wiki/Slowness)
the duration of the effect will be reset, and the
slow effect will be increased by 1, capped at
slowness IV.

Stray also has a 10% chance to drop a [ice](https://minecraft.fandom.com/wiki/Ice).

### Husk

Husk has a 10% chance to drop a sand block.

## Loot generation

Changes were made on loot generation.
At this point in time, only one change was
made: [Eye of Ender](https://minecraft.fandom.com/wiki/Eye_of_Ender)
can rarely spawn at most of the chests found
on any dimension.

- Eye of ender:
  - | Location      | Spawn Rate    | Amount |
    | ------------- |:-------------:| -----:|
    | Mineshaft     | 1% | 1-3 |
    | Bastion Treasure | 40% |  1-4  |
    | Bastion Bridge | 5% | 1-2 |
    | Bastion Hoglin Stable | 5% | 1-2 |
    | Buried Treasure | 2% | 1-2 |
    | End city Treasure | 10% | 1-5 |
    | Desert Pyramid | 1% | 1-2 |
    | Igloo | 5% | 1 |
    | Jungle Temple | 4% | 1-3 |
    | Nether Fortress | 30% | 1-5 |
    | Pillager Outpost | 5% | 1-2 |
    | Ruined Portal | 1% | 1-3 |
    | Shipwreck Treasure | 7% | 1-2 |
    | Shipwreck Supply | 3% | 1-3 |
    | Simple Dungeon | 1% | 1 |
    | Underwater big ruin | 8% | 1-2 |
    | Woodland Mansion | 15% | 1-5 |
  
## Recipes

Some recipes have been changed:

- Eye of Ender is no longer craftable and can
only be found by looting chests.
- Enchanted Golden Apple is now craftable with emerald
  block, nether star, golden apple and lapiz block.
  ![Enchanted Golden Apple craft](./assets/Enchanted_golden_apple_craft.png) 
