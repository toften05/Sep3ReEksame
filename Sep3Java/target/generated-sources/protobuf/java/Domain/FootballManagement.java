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
    internal_static_Domain_StringRequest_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_Domain_StringRequest_fieldAccessorTable;

  public static com.google.protobuf.Descriptors.FileDescriptor
      getDescriptor() {
    return descriptor;
  }
  private static  com.google.protobuf.Descriptors.FileDescriptor
      descriptor;
  static {
    java.lang.String[] descriptorData = {
      "\n\030FootballManagement.proto\022\006Domain\"(\n\030Pl" +
      "ayerCreationDTOMessage\022\014\n\004name\030\001 \001(\t\")\n\r" +
      "PlayerMessage\022\n\n\002id\030\001 \001(\005\022\014\n\004name\030\002 \001(\t\"" +
      "\037\n\rStringRequest\022\016\n\006string\030\001 \001(\t2\237\001\n\025Foo" +
      "tballPlayerService\022G\n\014CreatePlayer\022 .Dom" +
      "ain.PlayerCreationDTOMessage\032\025.Domain.Pl" +
      "ayerMessage\022=\n\rgetByUsername\022\025.Domain.St" +
      "ringRequest\032\025.Domain.PlayerMessageB\002P\001b\006" +
      "proto3"
    };
    descriptor = com.google.protobuf.Descriptors.FileDescriptor
      .internalBuildGeneratedFileFrom(descriptorData,
        new com.google.protobuf.Descriptors.FileDescriptor[] {
        });
    internal_static_Domain_PlayerCreationDTOMessage_descriptor =
      getDescriptor().getMessageTypes().get(0);
    internal_static_Domain_PlayerCreationDTOMessage_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_Domain_PlayerCreationDTOMessage_descriptor,
        new java.lang.String[] { "Name", });
    internal_static_Domain_PlayerMessage_descriptor =
      getDescriptor().getMessageTypes().get(1);
    internal_static_Domain_PlayerMessage_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_Domain_PlayerMessage_descriptor,
        new java.lang.String[] { "Id", "Name", });
    internal_static_Domain_StringRequest_descriptor =
      getDescriptor().getMessageTypes().get(2);
    internal_static_Domain_StringRequest_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_Domain_StringRequest_descriptor,
        new java.lang.String[] { "String", });
  }

  // @@protoc_insertion_point(outer_class_scope)
}
