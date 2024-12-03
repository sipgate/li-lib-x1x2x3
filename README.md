# Java Library for ETSI TS 103 221 Lawful Interception

## Metrics

In order to collect Metrics, implement the interface `MetricsService` and set it on the `X1Server`.

| Metric name                  | Type    | Tags              | Description                                                                                  |
| ---------------------------- | ------- | ----------------- | -------------------------------------------------------------------------------------------- |
| `li_x1_errorResponse`        | Counter | `request`, `code` | Number of returned X1 error responses                                                        |
| `li_x1_exception`            | Counter | `type`            | Number of requests that failed because of a Java exception (`type` is the simple class name) |
| `li_x1_handleRequestMessage` | Timer   | `type`            | Execution time of `handleRequestMessage`, type = SimpleClassName                             |
| `li_x1_requestContainer`     | Counter | `size`            | Number of X1 request container and their size                                                |
| `li_x1_requestError`         | Counter | `type`            | Number of requests that caused a TopLevelError (currently: `type`=`unknown_message_type`)    |
| `li_x1_requestMessage`       | Counter | `type`, `version` | Number of received X1 request messages, SimpleClassName and version in RequestMessage xml    |
| `li_x1_responseMessage`      | Counter | `type`            | Number of returned X1 response messages, type = SimpleClassName                              |

## Local development

1. `git clone` the repository
2. Run `npm install` for git hooks and prettier (code formatting)

## Generate Java Classes based on XSD

1. Get the main XSDs from
   - [https://www.etsi.org](https://www.etsi.org/standards-search#page=1&search=103%20221-1&title=1&etsiNumber=1&content=0&version=0&onApproval=1&published=1&withdrawn=1&historical=0&isCurrent=1&superseded=1&startDate=1988-01-15&endDate=2040-01-01&harmonized=0&keyword=&TB=&stdType=&frequency=&mandate=&collection=&sort=1)
2. Get XSD dependencies
   - https://www.etsi.org/deliver/etsi_ts/103200_103299/103280/02.12.01_60/
3. Extract all XSD files into [generate/src/main/resources](generate/src/main/resources)
4. Check the catalog file [generate/src/main/resources/ts_103.cat](generate/src/main/resources/ts_103.cat) for the correct schema location patches
   - look for the `<xs:import>` tags and check the filenames against the catalog
5. Generate the Java source files from the XSDs with `mvn clean verify`
6. Copy the generated Java files from `generate/target/generated-sources/xjc` to the `src/main/java` folder
   - look for the `org.etsi` package for the main classes
   - as well as the `com.kscs.util` package for the utilities from the rich-contract plugin

For your convenience we added a `Makefile` to do that for you (except the download part):

```bash
cd generate
make
```

## Further information

- TS 103 200 with multiple versions (PDF, XSDs, some versions have examples): https://www.etsi.org/deliver/etsi_ts/103200_103299/10322101/
