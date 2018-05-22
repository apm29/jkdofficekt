package com.example.dingzhu.zuoplus.model.bean

data class VideosItem(val duration: String = "",
                      val fileSize: String = "",
                      val format: String = "",
                      val videoId: String = "",
                      val tag: String = "",
                      val url: String = "")


data class RelateContsItem(val cornerLabel: String = "",
                           val cornerLabelDesc: String = "",
                           val videoType: String = "",
                           val link: String = "",
                           val praiseTimes: String = "",
                           val pic: String = "",
                           val forwordType: String = "",
                           val duration: String = "",
                           val contId: String = "",
                           val name: String = "",
                           val linkType: String = "",
                           val nodeInfo: NodeInfo,
                           val liveStatus: String = "")


data class ChildListItem(val stepTimes: String = "",
                         val userInfo: UserInfo,
                         val pubTime: String = "",
                         val replyTimes: String = "",
                         val commentId: String = "",
                         val topTimes: String = "",
                         val content: String = "")


data class AuthorsItem(val paikeType: String = "",
                       val nickname: String = "",
                       val isPaike: String = "",
                       val userId: String = "")


data class UserInfo(val nickname: String = "",
                    val isPaike: String = "",
                    val pic: String = "",
                    val userId: String = "")


data class ContentDetail(val nextInfo: NextInfo,
                         val postInfo: PostInfo,
                         val areaList: List<AreaListItem>?,
                         val resultCode: String = "",
                         val relateConts: List<RelateContsItem>?,
                         val systemTime: String = "",
                         val content: Content,
                         val resultMsg: String = "",
                         val reqId: String = "")






data class TagsItem(val tagId: String = "",
                    val name: String = "")




data class Content(val isDownload: String = "",
                   val sharePic: String = "",

                   val cornerLabelDesc: String = "",
                   val copyright: String = "",
                   val pubTime: String = "",
                   val liveRoomId: String = "",
                   val praiseTimes: String = "",
                   val aspectRatio: String = "",
                   val videos: List<VideosItem>?,
                   val source: String = "",
                   val pic: String = "",
                   val contentHtml: String = "",
                   val liveHtml: String = "",
                   val duration: String = "",
                   val contId: String = "",
                   val summary: String = "",
                   val cornerLabel: String = "",
                   val adMonitorUrl: String = "",
                   val isFavorited: String = "",
                   val commentTimes: String = "",
                   val postId: String = "",
                   val tags: List<TagsItem>?,
                   val postHtml: String = "",
                   val isVr: String = "",
                   val name: String = "",
                   val shareUrl: String = "",
                   val nodeInfo: NodeInfo,
                   val authors: List<AuthorsItem>?)


data class PostInfo(val postHtml: String = "",
                    val name: String = "",
                    val childList: List<ChildListItem>?,
                    val postId: String = "",
                    val commentTimes: String = "",
                    val communityInfo: CommunityInfo,
                    val isfavorited: String = "")



data class CommunityInfo(val logoImg: String = "",
                         val name: String = "",
                         val communityId: String = "")


data class NextInfo(val contId: String = "",
                    val name: String = "",
                    val forwordType: String = "")


