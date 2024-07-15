package com.sipgate.li.lib.x1;


import com.sipgate.li.lib.x1.etsi103280.QualifiedMicrosecondDateTime;
import com.sipgate.li.lib.x1.etsi103280.Uuid;
import com.sipgate.li.lib.x1.xs.Token;

import java.util.List;

public class X1Request {
    private List<X1RequestMessage> x1RequestMessages;
}

class X1RequestMessage {
    private AdmfIdentifier admfIdentifier;
    private NeIdentifier neIdentifier;
    private QualifiedMicrosecondDateTime messageTimestamp;
    private Version version;
    private X1TransactionId x1TransactionId;
}

class AdmfIdentifier extends Token {
}

class NeIdentifier extends Token {
}

class Version extends Token {
}

class X1TransactionId extends Uuid {
}

class ActivateTaskRequest extends X1RequestMessage {
    private TaskDetails taskDetails;
}

class TaskDetails {
    private XId xId;
    private ListOfTargetIdentifiers targetIdentifiers;
    private DeliveryType deliveryType;
    private ListOfDids listOfDIDs;
    private ListOfMediationDetails listOfMediationDetails;
    private NonNegativeInteger correlationID;
    private Boolean implicitDeactivationAllowed;
    private XId productID;
    private ListOfServiceTypes listOfServiceTypes;
    private List<TaskDetailsExtensions> taskDetailsExtensions;
    private ListOfTrafficPolicyReferences listOfTrafficPolicyReferences;
}
