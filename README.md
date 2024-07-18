# Java Library for ETSI TS 103 221 Lawful Interception

## Local development

1. `git clone` the repository
2. Run `npm install` for git hooks and prettier (code formatting)

## Generate Java Classes based on XSD

1. Get `xjc` from https://eclipse-ee4j.github.io/jaxb-ri/
2. Get the XSDs from https://www.etsi.org/standards-search#page=1&search=103%20221-1&title=1&etsiNumber=1&content=0&version=0&onApproval=1&published=1&withdrawn=1&historical=0&isCurrent=1&superseded=1&startDate=1988-01-15&endDate=2040-01-01&harmonized=0&keyword=&TB=&stdType=&frequency=&mandate=&collection=&sort=1
3. Get XSD dependencies
   - https://www.etsi.org/deliver/etsi_ts/103200_103299/103280/02.12.01_60/
4. Extract all XSD files in the same directory
5. Add `schemaLocation="..."` in `TS_103_221_01.xsd` for the `<xs:import>` tags

   ```xml
    3,4c3,4
    <     <xs:import namespace="http://uri.etsi.org/03280/common/2017/07"/>
    <     <xs:import namespace="http://uri.etsi.org/03221/X1/2017/10/HashedID"/>
    ---
    >     <xs:import namespace="http://uri.etsi.org/03280/common/2017/07" schemaLocation="TS_103_280.xsd"/>
    >     <xs:import namespace="http://uri.etsi.org/03221/X1/2017/10/HashedID" schemaLocation="TS_103_221_01_HashedID.xsd"/>
   ```

6. Run `xjc -d src/main/java TS_103_221_01.xsd` to generate Java classes

## Further information

- TS 103 200 with multiple versions (PDF, XSDs, some versions have examples): https://www.etsi.org/deliver/etsi_ts/103200_103299/10322101/
