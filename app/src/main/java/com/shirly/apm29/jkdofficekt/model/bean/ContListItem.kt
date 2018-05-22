package com.example.dingzhu.zuoplus.model.bean

data class ContListItem(val cornerLabel: String = "",
                        val cornerLabelDesc: String = "",
                        val videoType: String = "",
                        val link: String = "",
                        val praiseTimes: String = "",
                        val pic: String = "",
                        val forwordType: String = "",
                        val liveStartTime: String = "",
                        val duration: String = "",
                        val contId: String = "",
                        val name: String = "",
                        val linkType: String = "",
                        val nodeInfo: NodeInfo,
                        val liveStatus: String = "")