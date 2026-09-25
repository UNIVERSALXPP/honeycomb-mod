# Purple Honeycomb Wood (Fabric mod, MC 1.21.11)

Ye mod 2 cheezein karta hai:

1. **Honeycomb Stairs** naam ka naya block add karta hai (Honeycomb Block se craft hota hai, jaise normal stairs).
2. **Oak wood ko purple** kar deta hai (resource-pack style texture override) — planks, log, stripped log, door, trapdoor, wood block — sab ka texture wahi wood-grain pattern hai, bas color purple. Inn se craft hone wali cheezein (stairs, doors, trapdoors, fences) automatically purple dikhengi kyunki wo texture reuse karti hain.

> Agar aap chahte ho ki sirf ek naya "Purple Wood" wood-type bane (oak alag rahe, purple wood alag ho) to bata dena — abhi is version mein maine seedha **oak** ko purple kar diya hai kyunki request mein specific wood type mention nahi tha.

## Folder structure
```
src/main/java/com/example/purplehoney/PurpleHoneyMod.java   -> block/item register karta hai
src/main/resources/fabric.mod.json                          -> mod manifest
src/main/resources/assets/purplehoney/...                   -> honeycomb stairs textures/models
src/main/resources/assets/minecraft/textures/block/...       -> purple oak wood texture overrides
src/main/resources/data/purplehoney/recipe/...                -> crafting recipe
src/main/resources/data/purplehoney/loot_table/...            -> block loot table
```

## GitHub par build kaise karo

1. Is zip ko ek naye GitHub repo mein push kar do.
2. Ek baar local machine ya Codespaces mein `gradle wrapper` chala lo (ya IntelliJ mein project open karo, wo khud wrapper bana dega) taaki `gradlew` / `gradlew.bat` mil jaye. (Maine wrapper jar include nahi kiya kyunki mujhe internet access nahi hai yaha.)
3. Uske baad GitHub Actions se build karne ke liye `.github/workflows/build.yml` bana lo jisme:
   ```yaml
   name: build
   on: [push]
   jobs:
     build:
       runs-on: ubuntu-latest
       steps:
         - uses: actions/checkout@v4
         - uses: actions/setup-java@v4
           with:
             distribution: temurin
             java-version: 21
         - run: chmod +x ./gradlew && ./gradlew build
         - uses: actions/upload-artifact@v4
           with:
             name: purplehoney-mod
             path: build/libs/*.jar
   ```
4. Push karte hi Action chalega aur `build/libs/purplehoney-1.0.0.jar` artifact ke roop mein mil jayega — wahi apka mod jar hai, usko mods folder mein daal do (Fabric Loader + Fabric API 1.21.11 ke saath).

## Versions check kar lena
`gradle.properties` mein maine Yarn mappings / Fabric API ke jo version daale hain (1.21.11 ke liye), wo build se pehle ek baar [fabricmc.net/develop](https://fabricmc.net/develop) par confirm kar lena — kabhi kabhi exact build numbers change ho jaate hain.
