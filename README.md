# THOTH Example App
An android app for demonstrating the usage of the [THOTH](https://github.com/cristmasbox/THOTH) library.

> [!CAUTION]
> This app is only for testing purposes.

## Version Catalog
### 05.10.2025@1.0.0
This is the first release of the THOTH Example App
### 06.10.2025@1.0.1
Databases are updated.
Now it supports numbers as ids. This means you cant type in
```
<sign id="500"/>
```
instead of typing
```
<v><h><sign id="500"/><sign id="500"/><sign id="500"/></h><h><sign id="500"/><sign id="500"/></h></v>
```
### 26.10.2025@1.1.1
Support for MdC input added using the [GlyphConverter](https://github.com/cristmasbox/GlyphConverter) library.
### 08.11.2025@2.0.0
Support for brackets in MdC added. Now you can type in:
```
N17:i*(p:t)*(t:p)*i:N17
```
### 08.11.2025@2.0.1
Updated dependencies.
### 23.11.2025@2.0.2
Support for THOTH 2.0.2 added.
### 11.12.2025@2.0.3
- Issue with multiple render requests solved *(e.g. if you are changing the text two times shortly after each other)*
- Support for `maat:1.5.1` added:
  - adding Paddings between lines, signs, in groups or around the text as a whole is possible now
  - `RTL`-layout is supported and the signs are mirrored
  - multiline texts are possible with the `!` and `!!` sign in `MdC` and with `<br/>` and `<pbr/>` in `glyphX`

### 16.02.2026@2.0.4
Now it uses the [SignProvider-Library](https://github.com/cristmasbox/SignProvider) only.
### Newest Version
`16.02.2026@2.0.4`