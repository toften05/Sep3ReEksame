// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: FootballManagement.proto

package Domain;

public interface ListTeamMessageOrBuilder extends
    // @@protoc_insertion_point(interface_extends:Domain.ListTeamMessage)
    com.google.protobuf.MessageOrBuilder {

  /**
   * <code>repeated .Domain.TeamMessage teams = 1;</code>
   */
  java.util.List<Domain.TeamMessage> 
      getTeamsList();
  /**
   * <code>repeated .Domain.TeamMessage teams = 1;</code>
   */
  Domain.TeamMessage getTeams(int index);
  /**
   * <code>repeated .Domain.TeamMessage teams = 1;</code>
   */
  int getTeamsCount();
  /**
   * <code>repeated .Domain.TeamMessage teams = 1;</code>
   */
  java.util.List<? extends Domain.TeamMessageOrBuilder> 
      getTeamsOrBuilderList();
  /**
   * <code>repeated .Domain.TeamMessage teams = 1;</code>
   */
  Domain.TeamMessageOrBuilder getTeamsOrBuilder(
      int index);
}
