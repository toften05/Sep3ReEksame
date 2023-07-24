// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: FootballManagement.proto

package Domain;

public final class FootballManagement {
  private FootballManagement() {}
  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistryLite registry) {
  }

  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistry registry) {
    registerAllExtensions(
        (com.google.protobuf.ExtensionRegistryLite) registry);
  }
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_Domain_TeamCreationDTOMessage_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_Domain_TeamCreationDTOMessage_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_Domain_TeamMessage_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_Domain_TeamMessage_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_Domain_PlayerCreationDTOMessage_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_Domain_PlayerCreationDTOMessage_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_Domain_PlayerMessage_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_Domain_PlayerMessage_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_Domain_AllPlayersRequest_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_Domain_AllPlayersRequest_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_Domain_StringRequest_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_Domain_StringRequest_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_Domain_ListPlayerMessage_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_Domain_ListPlayerMessage_fieldAccessorTable;

  public static com.google.protobuf.Descriptors.FileDescriptor
      getDescriptor() {
    return descriptor;
  }
  private static  com.google.protobuf.Descriptors.FileDescriptor
      descriptor;
  static {
    java.lang.String[] descriptorData = {
      "\n\030FootballManagement.proto\022\006Domain\"N\n\026Te" +
      "amCreationDTOMessage\022\020\n\010teamName\030\001 \001(\t\022\020" +
      "\n\010division\030\002 \001(\t\022\020\n\010initials\030\003 \001(\t\"C\n\013Te" +
      "amMessage\022\020\n\010teamName\030\001 \001(\t\022\020\n\010division\030" +
      "\002 \001(\t\022\020\n\010initials\030\003 \001(\t\"(\n\030PlayerCreatio" +
      "nDTOMessage\022\014\n\004name\030\001 \001(\t\")\n\rPlayerMessa" +
      "ge\022\n\n\002id\030\001 \001(\005\022\014\n\004name\030\002 \001(\t\"\023\n\021AllPlaye" +
      "rsRequest\"\037\n\rStringRequest\022\016\n\006string\030\001 \001" +
      "(\t\";\n\021ListPlayerMessage\022&\n\007players\030\001 \003(\013" +
      "2\025.Domain.PlayerMessage2P\n\013TeamService\022A" +
      "\n\nCreateTeam\022\036.Domain.TeamCreationDTOMes" +
      "sage\032\023.Domain.TeamMessage2\346\001\n\025FootballPl" +
      "ayerService\022G\n\014CreatePlayer\022 .Domain.Pla" +
      "yerCreationDTOMessage\032\025.Domain.PlayerMes" +
      "sage\022=\n\rgetByUsername\022\025.Domain.StringReq" +
      "uest\032\025.Domain.PlayerMessage\022E\n\rgetAllPla" +
      "yers\022\031.Domain.AllPlayersRequest\032\031.Domain" +
      ".ListPlayerMessageB\021P\001\252\002\014GrpcServicesb\006p" +
      "roto3"
    };
    descriptor = com.google.protobuf.Descriptors.FileDescriptor
      .internalBuildGeneratedFileFrom(descriptorData,
        new com.google.protobuf.Descriptors.FileDescriptor[] {
        });
    internal_static_Domain_TeamCreationDTOMessage_descriptor =
      getDescriptor().getMessageTypes().get(0);
    internal_static_Domain_TeamCreationDTOMessage_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_Domain_TeamCreationDTOMessage_descriptor,
        new java.lang.String[] { "TeamName", "Division", "Initials", });
    internal_static_Domain_TeamMessage_descriptor =
      getDescriptor().getMessageTypes().get(1);
    internal_static_Domain_TeamMessage_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_Domain_TeamMessage_descriptor,
        new java.lang.String[] { "TeamName", "Division", "Initials", });
    internal_static_Domain_PlayerCreationDTOMessage_descriptor =
      getDescriptor().getMessageTypes().get(2);
    internal_static_Domain_PlayerCreationDTOMessage_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_Domain_PlayerCreationDTOMessage_descriptor,
        new java.lang.String[] { "Name", });
    internal_static_Domain_PlayerMessage_descriptor =
      getDescriptor().getMessageTypes().get(3);
    internal_static_Domain_PlayerMessage_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_Domain_PlayerMessage_descriptor,
        new java.lang.String[] { "Id", "Name", });
    internal_static_Domain_AllPlayersRequest_descriptor =
      getDescriptor().getMessageTypes().get(4);
    internal_static_Domain_AllPlayersRequest_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_Domain_AllPlayersRequest_descriptor,
        new java.lang.String[] { });
    internal_static_Domain_StringRequest_descriptor =
      getDescriptor().getMessageTypes().get(5);
    internal_static_Domain_StringRequest_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_Domain_StringRequest_descriptor,
        new java.lang.String[] { "String", });
    internal_static_Domain_ListPlayerMessage_descriptor =
      getDescriptor().getMessageTypes().get(6);
    internal_static_Domain_ListPlayerMessage_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_Domain_ListPlayerMessage_descriptor,
        new java.lang.String[] { "Players", });
  }

  // @@protoc_insertion_point(outer_class_scope)
}
