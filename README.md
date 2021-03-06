# Hardermode

---

:warning: Under development

---
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

- Players no damage ticks reduced by 50%.
- Any arrow with potion effect that hits a living
  entity that already has that same effect will
  have that effect amplified, capped at level V.
- Players that take damage from other entities and do not
  have a full set of armor will receive a damage
  penalty depending on which pieces, and how many are 
  missing:
  - Missing chestplate penalty: 50% extra damage taken;
  - Missing leggings penalty: 35% extra damage taken;
  - Missing helmet penalty: 10% extra damage taken;
  - Missing boots penalty: 5% extra damage taken;

## Mobs

Every mob categorized as [monster](https://hub.spigotmc.org/javadocs/spigot/org/bukkit/entity/Monster.html)
will spawn with different status from Vanilla:

- 50% maximum health increased;
- 60% base damage increased;
- 30% base armor increased;
- 50% arrow cooldown reduction;
- 100% follow range increased;

Also, any monster that spawns with a sword, axe, bow or
crossbow, have a 25% to have an enchantment on it:

- Swords and axes may gain sharpness from I to V;
- Bows may gain power from I to V;
- Crossbows may gain piercing up to IV;

### Creeper

[Creeper](https://minecraft.fandom.com/wiki/Creeper)
explosions will destroy a shield if a
player blocks the explosion. If the creeper is charged,
and you do not block it, your armor will take twice your
damage.

### Illagers

Any [Illager](https://minecraft.fandom.com/wiki/Illager)
have a 20% chance to prevent its own death by using
a [totem of undying](https://minecraft.fandom.com/wiki/Totem_of_Undying);

### Illusioner

Whenever a non-spellcaster [Illager](https://minecraft.fandom.com/wiki/Illager)
spawns, there is a 10% chance to spawn a
[Illusioner](https://minecraft.fandom.com/wiki/Illusioner)
instead.

### Skeleton

[Skeletons](https://minecraft.fandom.com/wiki/Skeleton)
(except stray and wither skeletons) have a 15% change to spawn with some
[tipped arrow](https://minecraft.fandom.com/wiki/Arrow#Tipped_arrows)
among 4:

- Arrow of Decay (which applies wither effect);
- Arrow of Harming;
- Arrow of Poison;
- Arrow of Weakness

If a skeleton spawn with any of those arrows,
he will drop it when killed.

#### Stray

Stray a 10% chance to drop a [ice](https://minecraft.fandom.com/wiki/Ice).

### Zombie

Any zombie has a 15% chance to spawn with a sword, or
an axe both made of any material.

#### Husk

Husk has a 10% chance to drop a sand block.

### Elder Guardian

To make more interesting to players, Elder Guardian
now have always to drop a [trident](https://minecraft.fandom.com/wiki/Trident)
and have 30% chance to drop an [Conduit](https://minecraft.fandom.com/wiki/Conduit).
It also got buffed:

- 80% more total health;
- 70% more base damage;
- 50% more base armor;

#### Battle

While fighting an Elder guardian, you will need to take
extra care. Hitting it with a melee attack will cause
the damager to be poisoned, if the damage is caused by
a projectile, its shooter will receive the blindness effect.

On death, it will explode with the same power of a [TNT](https://minecraft.fandom.com/wiki/TNT).
  
### Piglin Brute

Now, [Piglin Brute](https://minecraft.fandom.com/wiki/Piglin_Brute)
have a 5% chance to replace a normal piglin spawn. Which
means that he can spawn anywhere on the Nether.

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
    | Jungle Temple | 10% | 1-3 |
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
  block, nether star, golden apple and lapiz block;
  
  ![Enchanted Golden Apple craft](assets/recipes/enchanted_golden_apple_craft.png)
- Conduit craft has changed;
  
  ![Conduit craft](assets/recipes/conduit.png)

- Chests now require not only planks but also an
  iron nugget.

  ![Conduit craft](assets/recipes/chest.png)

- All diamonds, iron and golden armors have their recipes
  changed:
  
  ![Diamond Helmet](assets/recipes/diamond_helmet.png)

  ![Diamond Chestplate](assets/recipes/diamond_chestplate.png)
  
  ![Diamond leggings](assets/recipes/diamond_leggings.png)
  
  ![Diamond boots](assets/recipes/diamond_boots.png)

  ![Golden Helmet](assets/recipes/golden_helmet.png)

  ![Golden Chestplate](assets/recipes/golden_chestplate.png)

  ![Golden leggings](assets/recipes/golden_leggings.png)

  ![Golden boots](assets/recipes/golden_boots.png)

  ![Iron Helmet](assets/recipes/iron_helmet.png)

  ![Iron Chestplate](assets/recipes/iron_chestplate.png)

  ![Iron leggings](assets/recipes/iron_leggings.png)

  ![Iron boots](assets/recipes/iron_boots.png)

## Custom Items

There are items that have special name and lore. Those
items have special properties, if that item is made
for a specific player, that player will have special
interaction with it.

- Litwar's axe: A diamond axe that invoke three lighting
from skies after hitting a living entity.