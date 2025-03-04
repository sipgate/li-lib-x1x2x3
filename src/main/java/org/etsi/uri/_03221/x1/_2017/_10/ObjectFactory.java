//
// This file was generated by the Eclipse Implementation of JAXB, v4.0.5
// See https://eclipse-ee4j.github.io/jaxb-ri
// Any modifications to this file will be lost upon recompilation of the source schema.
//

package org.etsi.uri._03221.x1._2017._10;

import jakarta.xml.bind.JAXBElement;
import jakarta.xml.bind.annotation.XmlElementDecl;
import jakarta.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;

/**
 * This object contains factory methods for each
 * Java content interface and Java element interface
 * generated in the org.etsi.uri._03221.x1._2017._10 package.
 * <p>An ObjectFactory allows you to programmatically
 * construct new instances of the Java representation
 * for XML content. The Java representation of XML
 * content can consist of schema derived interfaces
 * and classes representing the binding of schema
 * type definitions, element declarations and model
 * groups.  Factory methods for each of these are
 * provided in this class.
 *
 */
@XmlRegistry
public class ObjectFactory {

  private static final QName _X1Request_QNAME = new QName("http://uri.etsi.org/03221/X1/2017/10", "X1Request");
  private static final QName _X1Response_QNAME = new QName("http://uri.etsi.org/03221/X1/2017/10", "X1Response");
  private static final QName _X1TopLevelErrorResponse_QNAME = new QName(
    "http://uri.etsi.org/03221/X1/2017/10",
    "X1TopLevelErrorResponse"
  );

  /**
   * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: org.etsi.uri._03221.x1._2017._10
   *
   */
  public ObjectFactory() {}

  /**
   * Create an instance of {@link RequestContainer }
   *
   * @return
   *     the new instance of {@link RequestContainer }
   */
  public RequestContainer createRequestContainer() {
    return new RequestContainer();
  }

  /**
   * Create an instance of {@link ResponseContainer }
   *
   * @return
   *     the new instance of {@link ResponseContainer }
   */
  public ResponseContainer createResponseContainer() {
    return new ResponseContainer();
  }

  /**
   * Create an instance of {@link TopLevelErrorResponse }
   *
   * @return
   *     the new instance of {@link TopLevelErrorResponse }
   */
  public TopLevelErrorResponse createTopLevelErrorResponse() {
    return new TopLevelErrorResponse();
  }

  /**
   * Create an instance of {@link X1RequestMessage }
   *
   * @return
   *     the new instance of {@link X1RequestMessage }
   */
  public X1RequestMessage createX1RequestMessage() {
    return new X1RequestMessage();
  }

  /**
   * Create an instance of {@link X1ResponseMessage }
   *
   * @return
   *     the new instance of {@link X1ResponseMessage }
   */
  public X1ResponseMessage createX1ResponseMessage() {
    return new X1ResponseMessage();
  }

  /**
   * Create an instance of {@link ErrorResponse }
   *
   * @return
   *     the new instance of {@link ErrorResponse }
   */
  public ErrorResponse createErrorResponse() {
    return new ErrorResponse();
  }

  /**
   * Create an instance of {@link ErrorInformation }
   *
   * @return
   *     the new instance of {@link ErrorInformation }
   */
  public ErrorInformation createErrorInformation() {
    return new ErrorInformation();
  }

  /**
   * Create an instance of {@link ExtensionInformation }
   *
   * @return
   *     the new instance of {@link ExtensionInformation }
   */
  public ExtensionInformation createExtensionInformation() {
    return new ExtensionInformation();
  }

  /**
   * Create an instance of {@link ActivateTaskRequest }
   *
   * @return
   *     the new instance of {@link ActivateTaskRequest }
   */
  public ActivateTaskRequest createActivateTaskRequest() {
    return new ActivateTaskRequest();
  }

  /**
   * Create an instance of {@link TaskDetails }
   *
   * @return
   *     the new instance of {@link TaskDetails }
   */
  public TaskDetails createTaskDetails() {
    return new TaskDetails();
  }

  /**
   * Create an instance of {@link ListOfTargetIdentifiers }
   *
   * @return
   *     the new instance of {@link ListOfTargetIdentifiers }
   */
  public ListOfTargetIdentifiers createListOfTargetIdentifiers() {
    return new ListOfTargetIdentifiers();
  }

  /**
   * Create an instance of {@link TargetIdentifier }
   *
   * @return
   *     the new instance of {@link TargetIdentifier }
   */
  public TargetIdentifier createTargetIdentifier() {
    return new TargetIdentifier();
  }

  /**
   * Create an instance of {@link TargetIdentifierExtension }
   *
   * @return
   *     the new instance of {@link TargetIdentifierExtension }
   */
  public TargetIdentifierExtension createTargetIdentifierExtension() {
    return new TargetIdentifierExtension();
  }

  /**
   * Create an instance of {@link MediationDetails }
   *
   * @return
   *     the new instance of {@link MediationDetails }
   */
  public MediationDetails createMediationDetails() {
    return new MediationDetails();
  }

  /**
   * Create an instance of {@link ListOfServiceScopingOptions }
   *
   * @return
   *     the new instance of {@link ListOfServiceScopingOptions }
   */
  public ListOfServiceScopingOptions createListOfServiceScopingOptions() {
    return new ListOfServiceScopingOptions();
  }

  /**
   * Create an instance of {@link ServiceScopingOptions }
   *
   * @return
   *     the new instance of {@link ServiceScopingOptions }
   */
  public ServiceScopingOptions createServiceScopingOptions() {
    return new ServiceScopingOptions();
  }

  /**
   * Create an instance of {@link ListOfServiceTypes }
   *
   * @return
   *     the new instance of {@link ListOfServiceTypes }
   */
  public ListOfServiceTypes createListOfServiceTypes() {
    return new ListOfServiceTypes();
  }

  /**
   * Create an instance of {@link LocationTypeOptions }
   *
   * @return
   *     the new instance of {@link LocationTypeOptions }
   */
  public LocationTypeOptions createLocationTypeOptions() {
    return new LocationTypeOptions();
  }

  /**
   * Create an instance of {@link ListOfLocationTypes }
   *
   * @return
   *     the new instance of {@link ListOfLocationTypes }
   */
  public ListOfLocationTypes createListOfLocationTypes() {
    return new ListOfLocationTypes();
  }

  /**
   * Create an instance of {@link LocationType }
   *
   * @return
   *     the new instance of {@link LocationType }
   */
  public LocationType createLocationType() {
    return new LocationType();
  }

  /**
   * Create an instance of {@link ListOfDids }
   *
   * @return
   *     the new instance of {@link ListOfDids }
   */
  public ListOfDids createListOfDids() {
    return new ListOfDids();
  }

  /**
   * Create an instance of {@link ListOfTrafficPolicyReferences }
   *
   * @return
   *     the new instance of {@link ListOfTrafficPolicyReferences }
   */
  public ListOfTrafficPolicyReferences createListOfTrafficPolicyReferences() {
    return new ListOfTrafficPolicyReferences();
  }

  /**
   * Create an instance of {@link ListOfMediationDetails }
   *
   * @return
   *     the new instance of {@link ListOfMediationDetails }
   */
  public ListOfMediationDetails createListOfMediationDetails() {
    return new ListOfMediationDetails();
  }

  /**
   * Create an instance of {@link TaskDetailsExtensions }
   *
   * @return
   *     the new instance of {@link TaskDetailsExtensions }
   */
  public TaskDetailsExtensions createTaskDetailsExtensions() {
    return new TaskDetailsExtensions();
  }

  /**
   * Create an instance of {@link MediationDetailsExtensions }
   *
   * @return
   *     the new instance of {@link MediationDetailsExtensions }
   */
  public MediationDetailsExtensions createMediationDetailsExtensions() {
    return new MediationDetailsExtensions();
  }

  /**
   * Create an instance of {@link TaskStatusExtensions }
   *
   * @return
   *     the new instance of {@link TaskStatusExtensions }
   */
  public TaskStatusExtensions createTaskStatusExtensions() {
    return new TaskStatusExtensions();
  }

  /**
   * Create an instance of {@link Extension }
   *
   * @return
   *     the new instance of {@link Extension }
   */
  public Extension createExtension() {
    return new Extension();
  }

  /**
   * Create an instance of {@link TaskIssueExtensions }
   *
   * @return
   *     the new instance of {@link TaskIssueExtensions }
   */
  public TaskIssueExtensions createTaskIssueExtensions() {
    return new TaskIssueExtensions();
  }

  /**
   * Create an instance of {@link NEIssueExtensions }
   *
   * @return
   *     the new instance of {@link NEIssueExtensions }
   */
  public NEIssueExtensions createNEIssueExtensions() {
    return new NEIssueExtensions();
  }

  /**
   * Create an instance of {@link ActivateTaskResponse }
   *
   * @return
   *     the new instance of {@link ActivateTaskResponse }
   */
  public ActivateTaskResponse createActivateTaskResponse() {
    return new ActivateTaskResponse();
  }

  /**
   * Create an instance of {@link ModifyTaskRequest }
   *
   * @return
   *     the new instance of {@link ModifyTaskRequest }
   */
  public ModifyTaskRequest createModifyTaskRequest() {
    return new ModifyTaskRequest();
  }

  /**
   * Create an instance of {@link ModifyTaskResponse }
   *
   * @return
   *     the new instance of {@link ModifyTaskResponse }
   */
  public ModifyTaskResponse createModifyTaskResponse() {
    return new ModifyTaskResponse();
  }

  /**
   * Create an instance of {@link DeactivateTaskRequest }
   *
   * @return
   *     the new instance of {@link DeactivateTaskRequest }
   */
  public DeactivateTaskRequest createDeactivateTaskRequest() {
    return new DeactivateTaskRequest();
  }

  /**
   * Create an instance of {@link DeactivateTaskResponse }
   *
   * @return
   *     the new instance of {@link DeactivateTaskResponse }
   */
  public DeactivateTaskResponse createDeactivateTaskResponse() {
    return new DeactivateTaskResponse();
  }

  /**
   * Create an instance of {@link DeactivateAllTasksRequest }
   *
   * @return
   *     the new instance of {@link DeactivateAllTasksRequest }
   */
  public DeactivateAllTasksRequest createDeactivateAllTasksRequest() {
    return new DeactivateAllTasksRequest();
  }

  /**
   * Create an instance of {@link DeactivateAllTasksResponse }
   *
   * @return
   *     the new instance of {@link DeactivateAllTasksResponse }
   */
  public DeactivateAllTasksResponse createDeactivateAllTasksResponse() {
    return new DeactivateAllTasksResponse();
  }

  /**
   * Create an instance of {@link CreateDestinationRequest }
   *
   * @return
   *     the new instance of {@link CreateDestinationRequest }
   */
  public CreateDestinationRequest createCreateDestinationRequest() {
    return new CreateDestinationRequest();
  }

  /**
   * Create an instance of {@link DestinationDetails }
   *
   * @return
   *     the new instance of {@link DestinationDetails }
   */
  public DestinationDetails createDestinationDetails() {
    return new DestinationDetails();
  }

  /**
   * Create an instance of {@link DeliveryAddress }
   *
   * @return
   *     the new instance of {@link DeliveryAddress }
   */
  public DeliveryAddress createDeliveryAddress() {
    return new DeliveryAddress();
  }

  /**
   * Create an instance of {@link DestinationDetailsExtensions }
   *
   * @return
   *     the new instance of {@link DestinationDetailsExtensions }
   */
  public DestinationDetailsExtensions createDestinationDetailsExtensions() {
    return new DestinationDetailsExtensions();
  }

  /**
   * Create an instance of {@link CreateDestinationResponse }
   *
   * @return
   *     the new instance of {@link CreateDestinationResponse }
   */
  public CreateDestinationResponse createCreateDestinationResponse() {
    return new CreateDestinationResponse();
  }

  /**
   * Create an instance of {@link ModifyDestinationRequest }
   *
   * @return
   *     the new instance of {@link ModifyDestinationRequest }
   */
  public ModifyDestinationRequest createModifyDestinationRequest() {
    return new ModifyDestinationRequest();
  }

  /**
   * Create an instance of {@link ModifyDestinationResponse }
   *
   * @return
   *     the new instance of {@link ModifyDestinationResponse }
   */
  public ModifyDestinationResponse createModifyDestinationResponse() {
    return new ModifyDestinationResponse();
  }

  /**
   * Create an instance of {@link RemoveDestinationRequest }
   *
   * @return
   *     the new instance of {@link RemoveDestinationRequest }
   */
  public RemoveDestinationRequest createRemoveDestinationRequest() {
    return new RemoveDestinationRequest();
  }

  /**
   * Create an instance of {@link RemoveDestinationResponse }
   *
   * @return
   *     the new instance of {@link RemoveDestinationResponse }
   */
  public RemoveDestinationResponse createRemoveDestinationResponse() {
    return new RemoveDestinationResponse();
  }

  /**
   * Create an instance of {@link RemoveAllDestinationsRequest }
   *
   * @return
   *     the new instance of {@link RemoveAllDestinationsRequest }
   */
  public RemoveAllDestinationsRequest createRemoveAllDestinationsRequest() {
    return new RemoveAllDestinationsRequest();
  }

  /**
   * Create an instance of {@link RemoveAllDestinationsResponse }
   *
   * @return
   *     the new instance of {@link RemoveAllDestinationsResponse }
   */
  public RemoveAllDestinationsResponse createRemoveAllDestinationsResponse() {
    return new RemoveAllDestinationsResponse();
  }

  /**
   * Create an instance of {@link GetTaskDetailsRequest }
   *
   * @return
   *     the new instance of {@link GetTaskDetailsRequest }
   */
  public GetTaskDetailsRequest createGetTaskDetailsRequest() {
    return new GetTaskDetailsRequest();
  }

  /**
   * Create an instance of {@link GetTaskDetailsResponse }
   *
   * @return
   *     the new instance of {@link GetTaskDetailsResponse }
   */
  public GetTaskDetailsResponse createGetTaskDetailsResponse() {
    return new GetTaskDetailsResponse();
  }

  /**
   * Create an instance of {@link TaskResponseDetails }
   *
   * @return
   *     the new instance of {@link TaskResponseDetails }
   */
  public TaskResponseDetails createTaskResponseDetails() {
    return new TaskResponseDetails();
  }

  /**
   * Create an instance of {@link TaskStatus }
   *
   * @return
   *     the new instance of {@link TaskStatus }
   */
  public TaskStatus createTaskStatus() {
    return new TaskStatus();
  }

  /**
   * Create an instance of {@link ListOfFaults }
   *
   * @return
   *     the new instance of {@link ListOfFaults }
   */
  public ListOfFaults createListOfFaults() {
    return new ListOfFaults();
  }

  /**
   * Create an instance of {@link GetDestinationDetailsRequest }
   *
   * @return
   *     the new instance of {@link GetDestinationDetailsRequest }
   */
  public GetDestinationDetailsRequest createGetDestinationDetailsRequest() {
    return new GetDestinationDetailsRequest();
  }

  /**
   * Create an instance of {@link GetDestinationDetailsResponse }
   *
   * @return
   *     the new instance of {@link GetDestinationDetailsResponse }
   */
  public GetDestinationDetailsResponse createGetDestinationDetailsResponse() {
    return new GetDestinationDetailsResponse();
  }

  /**
   * Create an instance of {@link DestinationResponseDetails }
   *
   * @return
   *     the new instance of {@link DestinationResponseDetails }
   */
  public DestinationResponseDetails createDestinationResponseDetails() {
    return new DestinationResponseDetails();
  }

  /**
   * Create an instance of {@link DestinationStatus }
   *
   * @return
   *     the new instance of {@link DestinationStatus }
   */
  public DestinationStatus createDestinationStatus() {
    return new DestinationStatus();
  }

  /**
   * Create an instance of {@link GetNEStatusRequest }
   *
   * @return
   *     the new instance of {@link GetNEStatusRequest }
   */
  public GetNEStatusRequest createGetNEStatusRequest() {
    return new GetNEStatusRequest();
  }

  /**
   * Create an instance of {@link GetNEStatusResponse }
   *
   * @return
   *     the new instance of {@link GetNEStatusResponse }
   */
  public GetNEStatusResponse createGetNEStatusResponse() {
    return new GetNEStatusResponse();
  }

  /**
   * Create an instance of {@link NeStatusDetails }
   *
   * @return
   *     the new instance of {@link NeStatusDetails }
   */
  public NeStatusDetails createNeStatusDetails() {
    return new NeStatusDetails();
  }

  /**
   * Create an instance of {@link GetAllDetailsRequest }
   *
   * @return
   *     the new instance of {@link GetAllDetailsRequest }
   */
  public GetAllDetailsRequest createGetAllDetailsRequest() {
    return new GetAllDetailsRequest();
  }

  /**
   * Create an instance of {@link GetAllDetailsResponse }
   *
   * @return
   *     the new instance of {@link GetAllDetailsResponse }
   */
  public GetAllDetailsResponse createGetAllDetailsResponse() {
    return new GetAllDetailsResponse();
  }

  /**
   * Create an instance of {@link ListOfTaskResponseDetails }
   *
   * @return
   *     the new instance of {@link ListOfTaskResponseDetails }
   */
  public ListOfTaskResponseDetails createListOfTaskResponseDetails() {
    return new ListOfTaskResponseDetails();
  }

  /**
   * Create an instance of {@link ListOfDestinationResponseDetails }
   *
   * @return
   *     the new instance of {@link ListOfDestinationResponseDetails }
   */
  public ListOfDestinationResponseDetails createListOfDestinationResponseDetails() {
    return new ListOfDestinationResponseDetails();
  }

  /**
   * Create an instance of {@link ListAllDetailsRequest }
   *
   * @return
   *     the new instance of {@link ListAllDetailsRequest }
   */
  public ListAllDetailsRequest createListAllDetailsRequest() {
    return new ListAllDetailsRequest();
  }

  /**
   * Create an instance of {@link ListAllDetailsResponse }
   *
   * @return
   *     the new instance of {@link ListAllDetailsResponse }
   */
  public ListAllDetailsResponse createListAllDetailsResponse() {
    return new ListAllDetailsResponse();
  }

  /**
   * Create an instance of {@link ListOfXids }
   *
   * @return
   *     the new instance of {@link ListOfXids }
   */
  public ListOfXids createListOfXids() {
    return new ListOfXids();
  }

  /**
   * Create an instance of {@link GetAllTaskDetailsRequest }
   *
   * @return
   *     the new instance of {@link GetAllTaskDetailsRequest }
   */
  public GetAllTaskDetailsRequest createGetAllTaskDetailsRequest() {
    return new GetAllTaskDetailsRequest();
  }

  /**
   * Create an instance of {@link GetAllTaskDetailsResponse }
   *
   * @return
   *     the new instance of {@link GetAllTaskDetailsResponse }
   */
  public GetAllTaskDetailsResponse createGetAllTaskDetailsResponse() {
    return new GetAllTaskDetailsResponse();
  }

  /**
   * Create an instance of {@link GetAllDestinationDetailsRequest }
   *
   * @return
   *     the new instance of {@link GetAllDestinationDetailsRequest }
   */
  public GetAllDestinationDetailsRequest createGetAllDestinationDetailsRequest() {
    return new GetAllDestinationDetailsRequest();
  }

  /**
   * Create an instance of {@link GetAllDestinationDetailsResponse }
   *
   * @return
   *     the new instance of {@link GetAllDestinationDetailsResponse }
   */
  public GetAllDestinationDetailsResponse createGetAllDestinationDetailsResponse() {
    return new GetAllDestinationDetailsResponse();
  }

  /**
   * Create an instance of {@link GetAllGenericObjectDetailsRequest }
   *
   * @return
   *     the new instance of {@link GetAllGenericObjectDetailsRequest }
   */
  public GetAllGenericObjectDetailsRequest createGetAllGenericObjectDetailsRequest() {
    return new GetAllGenericObjectDetailsRequest();
  }

  /**
   * Create an instance of {@link GetAllGenericObjectDetailsResponse }
   *
   * @return
   *     the new instance of {@link GetAllGenericObjectDetailsResponse }
   */
  public GetAllGenericObjectDetailsResponse createGetAllGenericObjectDetailsResponse() {
    return new GetAllGenericObjectDetailsResponse();
  }

  /**
   * Create an instance of {@link ReportTaskIssueRequest }
   *
   * @return
   *     the new instance of {@link ReportTaskIssueRequest }
   */
  public ReportTaskIssueRequest createReportTaskIssueRequest() {
    return new ReportTaskIssueRequest();
  }

  /**
   * Create an instance of {@link ReportTaskIssueResponse }
   *
   * @return
   *     the new instance of {@link ReportTaskIssueResponse }
   */
  public ReportTaskIssueResponse createReportTaskIssueResponse() {
    return new ReportTaskIssueResponse();
  }

  /**
   * Create an instance of {@link ReportDestinationIssueRequest }
   *
   * @return
   *     the new instance of {@link ReportDestinationIssueRequest }
   */
  public ReportDestinationIssueRequest createReportDestinationIssueRequest() {
    return new ReportDestinationIssueRequest();
  }

  /**
   * Create an instance of {@link ReportDestinationIssueResponse }
   *
   * @return
   *     the new instance of {@link ReportDestinationIssueResponse }
   */
  public ReportDestinationIssueResponse createReportDestinationIssueResponse() {
    return new ReportDestinationIssueResponse();
  }

  /**
   * Create an instance of {@link ReportNEIssueRequest }
   *
   * @return
   *     the new instance of {@link ReportNEIssueRequest }
   */
  public ReportNEIssueRequest createReportNEIssueRequest() {
    return new ReportNEIssueRequest();
  }

  /**
   * Create an instance of {@link ReportNEIssueResponse }
   *
   * @return
   *     the new instance of {@link ReportNEIssueResponse }
   */
  public ReportNEIssueResponse createReportNEIssueResponse() {
    return new ReportNEIssueResponse();
  }

  /**
   * Create an instance of {@link PingRequest }
   *
   * @return
   *     the new instance of {@link PingRequest }
   */
  public PingRequest createPingRequest() {
    return new PingRequest();
  }

  /**
   * Create an instance of {@link PingResponse }
   *
   * @return
   *     the new instance of {@link PingResponse }
   */
  public PingResponse createPingResponse() {
    return new PingResponse();
  }

  /**
   * Create an instance of {@link KeepaliveRequest }
   *
   * @return
   *     the new instance of {@link KeepaliveRequest }
   */
  public KeepaliveRequest createKeepaliveRequest() {
    return new KeepaliveRequest();
  }

  /**
   * Create an instance of {@link KeepaliveResponse }
   *
   * @return
   *     the new instance of {@link KeepaliveResponse }
   */
  public KeepaliveResponse createKeepaliveResponse() {
    return new KeepaliveResponse();
  }

  /**
   * Create an instance of {@link CreateObjectRequest }
   *
   * @return
   *     the new instance of {@link CreateObjectRequest }
   */
  public CreateObjectRequest createCreateObjectRequest() {
    return new CreateObjectRequest();
  }

  /**
   * Create an instance of {@link CreateObjectResponse }
   *
   * @return
   *     the new instance of {@link CreateObjectResponse }
   */
  public CreateObjectResponse createCreateObjectResponse() {
    return new CreateObjectResponse();
  }

  /**
   * Create an instance of {@link ModifyObjectRequest }
   *
   * @return
   *     the new instance of {@link ModifyObjectRequest }
   */
  public ModifyObjectRequest createModifyObjectRequest() {
    return new ModifyObjectRequest();
  }

  /**
   * Create an instance of {@link ModifyObjectResponse }
   *
   * @return
   *     the new instance of {@link ModifyObjectResponse }
   */
  public ModifyObjectResponse createModifyObjectResponse() {
    return new ModifyObjectResponse();
  }

  /**
   * Create an instance of {@link GetObjectRequest }
   *
   * @return
   *     the new instance of {@link GetObjectRequest }
   */
  public GetObjectRequest createGetObjectRequest() {
    return new GetObjectRequest();
  }

  /**
   * Create an instance of {@link GetObjectResponse }
   *
   * @return
   *     the new instance of {@link GetObjectResponse }
   */
  public GetObjectResponse createGetObjectResponse() {
    return new GetObjectResponse();
  }

  /**
   * Create an instance of {@link GenericObjectResponseDetails }
   *
   * @return
   *     the new instance of {@link GenericObjectResponseDetails }
   */
  public GenericObjectResponseDetails createGenericObjectResponseDetails() {
    return new GenericObjectResponseDetails();
  }

  /**
   * Create an instance of {@link ListOfGenericObjectResponseDetails }
   *
   * @return
   *     the new instance of {@link ListOfGenericObjectResponseDetails }
   */
  public ListOfGenericObjectResponseDetails createListOfGenericObjectResponseDetails() {
    return new ListOfGenericObjectResponseDetails();
  }

  /**
   * Create an instance of {@link GenericObjectStatus }
   *
   * @return
   *     the new instance of {@link GenericObjectStatus }
   */
  public GenericObjectStatus createGenericObjectStatus() {
    return new GenericObjectStatus();
  }

  /**
   * Create an instance of {@link DeleteObjectRequest }
   *
   * @return
   *     the new instance of {@link DeleteObjectRequest }
   */
  public DeleteObjectRequest createDeleteObjectRequest() {
    return new DeleteObjectRequest();
  }

  /**
   * Create an instance of {@link DeleteObjectResponse }
   *
   * @return
   *     the new instance of {@link DeleteObjectResponse }
   */
  public DeleteObjectResponse createDeleteObjectResponse() {
    return new DeleteObjectResponse();
  }

  /**
   * Create an instance of {@link ListObjectsOfTypeRequest }
   *
   * @return
   *     the new instance of {@link ListObjectsOfTypeRequest }
   */
  public ListObjectsOfTypeRequest createListObjectsOfTypeRequest() {
    return new ListObjectsOfTypeRequest();
  }

  /**
   * Create an instance of {@link ListObjectsOfTypeResponse }
   *
   * @return
   *     the new instance of {@link ListObjectsOfTypeResponse }
   */
  public ListObjectsOfTypeResponse createListObjectsOfTypeResponse() {
    return new ListObjectsOfTypeResponse();
  }

  /**
   * Create an instance of {@link ListOfGenericObjectIDs }
   *
   * @return
   *     the new instance of {@link ListOfGenericObjectIDs }
   */
  public ListOfGenericObjectIDs createListOfGenericObjectIDs() {
    return new ListOfGenericObjectIDs();
  }

  /**
   * Create an instance of {@link DeleteAllObjectsRequest }
   *
   * @return
   *     the new instance of {@link DeleteAllObjectsRequest }
   */
  public DeleteAllObjectsRequest createDeleteAllObjectsRequest() {
    return new DeleteAllObjectsRequest();
  }

  /**
   * Create an instance of {@link DeleteAllObjectsResponse }
   *
   * @return
   *     the new instance of {@link DeleteAllObjectsResponse }
   */
  public DeleteAllObjectsResponse createDeleteAllObjectsResponse() {
    return new DeleteAllObjectsResponse();
  }

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link RequestContainer }{@code >}
   *
   * @param value
   *     Java instance representing xml element's value.
   * @return
   *     the new instance of {@link JAXBElement }{@code <}{@link RequestContainer }{@code >}
   */
  @XmlElementDecl(namespace = "http://uri.etsi.org/03221/X1/2017/10", name = "X1Request")
  public JAXBElement<RequestContainer> createX1Request(RequestContainer value) {
    return new JAXBElement<>(_X1Request_QNAME, RequestContainer.class, null, value);
  }

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link ResponseContainer }{@code >}
   *
   * @param value
   *     Java instance representing xml element's value.
   * @return
   *     the new instance of {@link JAXBElement }{@code <}{@link ResponseContainer }{@code >}
   */
  @XmlElementDecl(namespace = "http://uri.etsi.org/03221/X1/2017/10", name = "X1Response")
  public JAXBElement<ResponseContainer> createX1Response(ResponseContainer value) {
    return new JAXBElement<>(_X1Response_QNAME, ResponseContainer.class, null, value);
  }

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link TopLevelErrorResponse }{@code >}
   *
   * @param value
   *     Java instance representing xml element's value.
   * @return
   *     the new instance of {@link JAXBElement }{@code <}{@link TopLevelErrorResponse }{@code >}
   */
  @XmlElementDecl(namespace = "http://uri.etsi.org/03221/X1/2017/10", name = "X1TopLevelErrorResponse")
  public JAXBElement<TopLevelErrorResponse> createX1TopLevelErrorResponse(TopLevelErrorResponse value) {
    return new JAXBElement<>(_X1TopLevelErrorResponse_QNAME, TopLevelErrorResponse.class, null, value);
  }
}
