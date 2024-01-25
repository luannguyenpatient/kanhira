package com.cm55.kanhira;

import java.util.*;

/**
 * 異体字を普通字に変換するためのテーブル。
 * 例えば、難しい「學」を普通の「学」に変換する。
 * @author admin
 */
public class ItaijiTable {

  /** 異体字/普通字テーブル */
  private static char[] TABLE = { 
      '丗', '世', // 0x4e17
      '乕', '虎', // 0x4e55
      '乘', '乗', // 0x4e58
      '亂', '乱', // 0x4e82
      '亊', '事', // 0x4e8a
      '亘', '亙', // 0x4e98
      '亞', '亜', // 0x4e9e
      '亰', '京', // 0x4eb0
      '从', '従', // 0x4ece
      '仭', '仞', // 0x4eed
      '伜', '倅', // 0x4f1c
      '佛', '仏', // 0x4f5b
      '來', '来', // 0x4f86
      '侫', '佞', // 0x4fab
      '假', '仮', // 0x5047
      '做', '作', // 0x505a
      '傳', '伝', // 0x50b3
      '僞', '偽', // 0x50de
      '價', '価', // 0x50f9
      '儉', '倹', // 0x5109
      '儘', '侭', // 0x5118
      '兒', '児', // 0x5152
      '兔', '兎', // 0x5154
      '兩', '両', // 0x5169
      '册', '冊', // 0x518c
      '冐', '冒', // 0x5190
      '冢', '塚', // 0x51a2
      '冨', '富', // 0x51a8
      '冩', '写', // 0x51a9
      '冰', '氷', // 0x51b0
      '冱', '冴', // 0x51b1
      '决', '決', // 0x51b3
      '况', '況', // 0x51b5
      '凉', '涼', // 0x51c9
      '凖', '準', // 0x51d6
      '凜', '凛', // 0x51dc
      '凾', '函', // 0x51fe
      '刄', '刃', // 0x5204
      '刔', '抉', // 0x5214
      '刧', '劫', // 0x5227
      '剩', '剰', // 0x5269
      '剱', '剣', // 0x5271
      '劍', '剣', // 0x528d
      '劑', '剤', // 0x5291
      '劒', '剣', // 0x5292
      '劔', '剣', // 0x5294
      '勞', '労', // 0x52de
      '勳', '勲', // 0x52f3
      '勵', '励', // 0x52f5
      '勸', '勧', // 0x52f8
      '區', '区', // 0x5340
      '卆', '卒', // 0x5346
      '卷', '巻', // 0x5377
      '卻', '却', // 0x537b
      '厠', '廁', // 0x53a0
      '厦', '廈', // 0x53a6
      '厮', '廝', // 0x53ae
      '厰', '廠', // 0x53b0
      '參', '参', // 0x53c3
      '咒', '呪', // 0x5492
      '單', '単', // 0x55ae
      '噐', '器', // 0x5650
      '嚏', '嚔', // 0x568f
      '嚴', '厳', // 0x56b4
      '囑', '嘱', // 0x56d1
      '囓', '齧', // 0x56d3
      '囘', '回', // 0x56d8
      '圀', '国', // 0x5700
      '圈', '圏', // 0x5708
      '國', '国', // 0x570b
      '圍', '囲', // 0x570d
      '圓', '円', // 0x5713
      '圖', '図', // 0x5716
      '團', '団', // 0x5718
      '埀', '垂', // 0x57c0
      '埓', '埒', // 0x57d3
      '塲', '場', // 0x5872
      '墮', '堕', // 0x58ae
      '壓', '圧', // 0x58d3
      '壘', '塁', // 0x58d8
      '壞', '壊', // 0x58de
      '壤', '壌', // 0x58e4
      '壥', '廛', // 0x58e5
      '壯', '壮', // 0x58ef
      '壱', '一', // 0x58f1
      '壹', '一', // 0x58f9
      '壺', '壷', // 0x58fa
      '壻', '婿', // 0x58fb
      '壽', '寿', // 0x58fd
      '夂', '夊', // 0x5902
      '夘', '卯', // 0x5918
      '夛', '多', // 0x591b
      '奧', '奥', // 0x5967
      '奬', '奨', // 0x596c
      '姙', '妊', // 0x59d9
      '嫻', '嫺', // 0x5afb
      '孃', '嬢', // 0x5b43
      '學', '学', // 0x5b78
      '寃', '冤', // 0x5bc3
      '寇', '冦', // 0x5bc7
      '寢', '寝', // 0x5be2
      '寫', '写', // 0x5beb
      '寳', '宝', // 0x5bf3
      '寶', '宝', // 0x5bf6
      '尅', '剋', // 0x5c05
      '將', '将', // 0x5c07
      '專', '専', // 0x5c08
      '對', '対', // 0x5c0d
      '尓', '爾', // 0x5c13
      '尢', '尤', // 0x5c22
      '屆', '届', // 0x5c46
      '屬', '属', // 0x5c6c
      '峯', '峰', // 0x5cef
      '島', '嶋', // 0x5cf6
      '峽', '峡', // 0x5cfd
      '崙', '崘', // 0x5d19
      '嵜', '崎', // 0x5d5c
      '嵳', '嵯', // 0x5d73
      '嶌', '嶋', // 0x5d8c
      '嶽', '岳', // 0x5dbd
      '巛', '川', // 0x5ddb
      '巵', '卮', // 0x5df5
      '帋', '紙', // 0x5e0b
      '帶', '帯', // 0x5e36
      '幤', '幣', // 0x5e64
      '廏', '厩', // 0x5ecf
      '廐', '厩', // 0x5ed0
      '廚', '厨', // 0x5eda
      '廢', '廃', // 0x5ee2
      '廣', '広', // 0x5ee3
      '廰', '庁', // 0x5ef0
      '廳', '庁', // 0x5ef3
      '廸', '迪', // 0x5ef8
      '弃', '棄', // 0x5f03
      '弉', '奘', // 0x5f09
      '弌', '一', // 0x5f0c
      '弍', '二', // 0x5f0d
      '弯', '彎', // 0x5f2f
      '彈', '弾', // 0x5f48
      '彌', '弥', // 0x5f4c
      '彜', '彝', // 0x5f5c
      '徃', '往', // 0x5f83
      '徑', '径', // 0x5f91
      '從', '従', // 0x5f9e
      '徠', '来', // 0x5fa0
      '忰', '悴', // 0x5ff0
      '恆', '恒', // 0x6046
      '恠', '怪', // 0x6060
      '悧', '俐', // 0x60a7
      '悳', '徳', // 0x60b3
      '惠', '恵', // 0x60e0
      '惡', '悪', // 0x60e1
      '惱', '悩', // 0x60f1
      '愼', '慎', // 0x613c
      '愽', '博', // 0x613d
      '慘', '惨', // 0x6158
      '慚', '慙', // 0x615a
      '憇', '憩', // 0x6187
      '應', '応', // 0x61c9
      '懴', '懺', // 0x61f4
      '懷', '懐', // 0x61f7
      '戀', '恋', // 0x6200
      '戝', '財', // 0x621d
      '戞', '戛', // 0x621e
      '戰', '戦', // 0x6230
      '戲', '戯', // 0x6232
      '抬', '擡', // 0x62ac
      '拂', '払', // 0x62c2
      '拏', '拿', // 0x62cf
      '拔', '抜', // 0x62d4
      '拜', '拝', // 0x62dc
      '挾', '挟', // 0x633e
      '插', '挿', // 0x63d2
      '搖', '揺', // 0x6416
      '搜', '捜', // 0x641c
      '擇', '択', // 0x64c7
      '擔', '担', // 0x64d4
      '據', '拠', // 0x64da
      '擧', '拳', // 0x64e7
      '擴', '拡', // 0x64f4
      '攜', '携', // 0x651c
      '攝', '摂', // 0x651d
      '攪', '撹', // 0x652a
      '攵', '攴', // 0x6535
      '收', '収', // 0x6536
      '攷', '考', // 0x6537
      '效', '効', // 0x6548
      '敍', '叙', // 0x654d
      '敕', '勅', // 0x6555
      '敘', '叙', // 0x6558
      '數', '数', // 0x6578
      '斈', '学', // 0x6588
      '斷', '断', // 0x65b7
      '旙', '旛', // 0x65d9
      '昜', '陽', // 0x661c
      '昿', '曠', // 0x663f
      '晄', '晃', // 0x6644
      '晉', '晋', // 0x6649
      '晝', '昼', // 0x665d
      '晰', '晢', // 0x6670
      '暎', '映', // 0x668e
      '暸', '瞭', // 0x66b8
      '曉', '暁', // 0x66c9
      '曵', '曳', // 0x66f5
      '曽', '曾', // 0x66fd
      '會', '会', // 0x6703
      '朖', '朗', // 0x6716
      '朞', '期', // 0x671e
      '杤', '栃', // 0x6764
      '杰', '傑', // 0x6770
      '枩', '松', // 0x67a9
      '條', '条', // 0x689d
      '梦', '夢', // 0x68a6
      '梹', '檳', // 0x68b9
      '棊', '棋', // 0x68ca
      '棕', '椶', // 0x68d5
      '棧', '桟', // 0x68e7
      '楙', '茂', // 0x6959
      '榮', '栄', // 0x69ae
      '槇', '槙', // 0x69c7
      '槨', '椁', // 0x69e8
      '樂', '楽', // 0x6a02
      '樓', '楼', // 0x6a13
      '樞', '枢', // 0x6a1e
      '樣', '様', // 0x6a23
      '橢', '楕', // 0x6a62
      '檜', '桧', // 0x6a9c
      '檢', '検', // 0x6aa2
      '檮', '梼', // 0x6aae
      '櫻', '桜', // 0x6afb
      '權', '権', // 0x6b0a
      '歐', '嘔', // 0x6b50
      '歡', '歓', // 0x6b61
      '歸', '帰', // 0x6b78
      '殘', '残', // 0x6b98
      '殱', '殲', // 0x6bb1
      '殼', '殻', // 0x6bbc
      '毆', '殴', // 0x6bc6
      '毓', '育', // 0x6bd3
      '氣', '気', // 0x6c23
      '沒', '没', // 0x6c92
      '泪', '涙', // 0x6cea
      '淨', '浄', // 0x6de8
      '淺', '浅', // 0x6dfa
      '渊', '淵', // 0x6e0a
      '渕', '淵', // 0x6e15
      '溂', '剌', // 0x6e82
      '溪', '渓', // 0x6eaa
      '滯', '滞', // 0x6eef
      '滿', '満', // 0x6eff
      '潛', '潜', // 0x6f5b
      '澀', '渋', // 0x6f80
      '澁', '渋', // 0x6f81
      '澂', '澄', // 0x6f82
      '澑', '溜', // 0x6f91
      '澤', '沢', // 0x6fa4
      '濕', '湿', // 0x6fd5
      '濟', '済', // 0x6fdf
      '濤', '涛', // 0x6fe4
      '濱', '浜', // 0x6ff1
      '濳', '潜', // 0x6ff3
      '濶', '闊', // 0x6ff6
      '濾', '滬', // 0x6ffe
      '灌', '潅', // 0x704c
      '灣', '湾', // 0x7063
      '烟', '煙', // 0x70df
      '烱', '炯', // 0x70f1
      '熈', '煕', // 0x7188
      '熏', '燻', // 0x718f
      '熙', '煕', // 0x7199
      '燒', '焼', // 0x71d2
      '營', '営', // 0x71df
      '爐', '炉', // 0x7210
      '爭', '争', // 0x722d
      '爲', '為', // 0x7232
      '爼', '俎', // 0x723c
      '犁', '犂', // 0x7281
      '犲', '豺', // 0x72b2
      '犹', '猶', // 0x72b9
      '狹', '狭', // 0x72f9
      '獎', '奨', // 0x734e
      '獨', '独', // 0x7368
      '獵', '猟', // 0x7375
      '獸', '獣', // 0x7378
      '獻', '献', // 0x737b
      '珎', '珍', // 0x73ce
      '珱', '瓔', // 0x73f1
      '瑤', '瑶', // 0x7464
      '瑯', '琅', // 0x746f
      '璢', '瑠', // 0x74a2
      '瓣', '弁', // 0x74e3
      '甞', '嘗', // 0x751e
      '甼', '町', // 0x753c
      '畄', '留', // 0x7544
      '畆', '畝', // 0x7546
      '畊', '耕', // 0x754a
      '畍', '界', // 0x754d
      '畧', '略', // 0x7567
      '畫', '画', // 0x756b
      '畴', '疇', // 0x7574
      '當', '当', // 0x7576
      '疂', '畳', // 0x7582
      '疉', '畳', // 0x7589
      '疊', '畳', // 0x758a
      '癡', '痴', // 0x7661
      '發', '発', // 0x767c
      '皃', '猊', // 0x7683
      '皈', '帰', // 0x7688
      '皷', '鼓', // 0x76b7
      '皹', '皸', // 0x76b9
      '盃', '杯', // 0x76c3
      '盖', '蓋', // 0x76d6
      '盜', '盗', // 0x76dc
      '盡', '尽', // 0x76e1
      '眞', '真', // 0x771e
      '眦', '眥', // 0x7726
      '碎', '砕', // 0x788e
      '碯', '瑙', // 0x78af
      '礦', '鉱', // 0x7926
      '礪', '砺', // 0x792a
      '祕', '秘', // 0x7955
      '祿', '禄', // 0x797f
      '禀', '稟', // 0x7980
      '禪', '禅', // 0x79aa
      '禮', '礼', // 0x79ae
      '稱', '称', // 0x7a31
      '稻', '稲', // 0x7a3b
      '稾', '稿', // 0x7a3e
      '穗', '穂', // 0x7a57
      '穩', '穏', // 0x7a69
      '穰', '穣', // 0x7a70
      '窗', '窓', // 0x7a97
      '窰', '窯', // 0x7ab0
      '竈', '竃', // 0x7ac8
      '竊', '窃', // 0x7aca
      '竒', '奇', // 0x7ad2
      '竝', '並', // 0x7add
      '竸', '競', // 0x7af8
      '笋', '筍', // 0x7b0b
      '筝', '箏', // 0x7b5d
      '筺', '筐', // 0x7b7a
      '箟', '箘', // 0x7b9f
      '簔', '蓑', // 0x7c14
      '籖', '籤', // 0x7c56
      '籘', '籐', // 0x7c58
      '籠', '篭', // 0x7c60
      '粹', '粋', // 0x7cb9
      '糺', '糾', // 0x7cfa
      '絲', '糸', // 0x7d72
      '經', '経', // 0x7d93
      '緕', '纃', // 0x7dd5
      '緜', '綿', // 0x7ddc
      '縣', '県', // 0x7e23
      '縱', '縦', // 0x7e31
      '總', '総', // 0x7e3d
      '繩', '縄', // 0x7e69
      '繪', '絵', // 0x7e6a
      '繼', '継', // 0x7e7c
      '續', '続', // 0x7e8c
      '纎', '繊', // 0x7e8e
      '纖', '繊', // 0x7e96
      '纜', '繿', // 0x7e9c
      '缺', '欠', // 0x7f3a
      '罐', '缶', // 0x7f50
      '罸', '罰', // 0x7f78
      '羃', '冪', // 0x7f83
      '羣', '群', // 0x7fa3
      '羮', '羹', // 0x7fae
      '翆', '翠', // 0x7fc6
      '翦', '剪', // 0x7fe6
      '耻', '恥', // 0x803b
      '聟', '婿', // 0x805f
      '聨', '聯', // 0x8068
      '聰', '聡', // 0x8070
      '聲', '声', // 0x8072
      '聽', '聴', // 0x807d
      '肅', '粛', // 0x8085
      '脉', '脈', // 0x8109
      '腟', '膣', // 0x815f
      '腦', '脳', // 0x8166
      '膓', '腸', // 0x8193
      '膸', '髄', // 0x81b8
      '膽', '胆', // 0x81bd
      '臈', '臘', // 0x81c8
      '臟', '臓', // 0x81df
      '臺', '台', // 0x81fa
      '與', '与', // 0x8207
      '舉', '拳', // 0x8209
      '舊', '旧', // 0x820a
      '舍', '舎', // 0x820d
      '舖', '舗', // 0x8216
      '舘', '館', // 0x8218
      '舩', '船', // 0x8229
      '舮', '艫', // 0x822e
      '艢', '檣', // 0x8262
      '艷', '艶', // 0x8277
      '芦', '蘆', // 0x82a6
      '苅', '刈', // 0x82c5
      '莊', '荘', // 0x838a
      '莖', '茎', // 0x8396
      '莵', '兎', // 0x83b5
      '菟', '兎', // 0x83df
      '菷', '帚', // 0x83f7
      '萠', '萌', // 0x8420
      '萬', '万', // 0x842c
      '葢', '蓋', // 0x8462
      '蒂', '蔕', // 0x8482
      '蕋', '蕊', // 0x854b
      '蕚', '萼', // 0x855a
      '藏', '蔵', // 0x85cf
      '藝', '芸', // 0x85dd
      '藥', '薬', // 0x85e5
      '藪', '薮', // 0x85ea
      '蘂', '蕊', // 0x8602
      '蘓', '蘇', // 0x8613
      '蘯', '盪', // 0x862f
      '處', '処', // 0x8655
      '號', '号', // 0x865f
      '蝨', '虱', // 0x8768
      '螢', '蛍', // 0x87a2
      '蟆', '蟇', // 0x87c6
      '蟒', '蠎', // 0x87d2
      '蟲', '虫', // 0x87f2
      '蟷', '螳', // 0x87f7
      '蠅', '蝿', // 0x8805
      '蠏', '蟹', // 0x880f
      '蠣', '蛎', // 0x8823
      '蠧', '蠹', // 0x8827
      '蠶', '蚕', // 0x8836
      '蠻', '蛮', // 0x883b
      '衂', '衄', // 0x8842
      '衞', '衛', // 0x885e
      '袵', '衽', // 0x88b5
      '裝', '装', // 0x88dd
      '褝', '襌', // 0x891d
      '襃', '褒', // 0x8943
      '襍', '雑', // 0x894d
      '覩', '睹', // 0x89a9
      '覺', '覚', // 0x89ba
      '覽', '覧', // 0x89bd
      '觀', '観', // 0x89c0
      '觧', '解', // 0x89e7
      '觸', '触', // 0x89f8
      '誡', '戒', // 0x8aa1
      '諡', '謚', // 0x8ae1
      '謌', '歌', // 0x8b0c
      '謠', '謡', // 0x8b20
      '證', '証', // 0x8b49
      '譛', '譖', // 0x8b5b
      '譯', '訳', // 0x8b6f
      '譱', '善', // 0x8b71
      '譽', '誉', // 0x8b7d
      '讀', '読', // 0x8b80
      '變', '変', // 0x8b8a
      '讓', '譲', // 0x8b93
      '讚', '賛', // 0x8b9a
      '豐', '豊', // 0x8c50
      '豫', '予', // 0x8c6b
      '豼', '貔', // 0x8c7c
      '貉', '狢', // 0x8c89
      '貍', '狸', // 0x8c8d
      '貎', '猊', // 0x8c8e
      '貘', '獏', // 0x8c98
      '貭', '質', // 0x8cad
      '貮', '弐', // 0x8cae
      '貳', '弐', // 0x8cb3
      '賍', '贓', // 0x8ccd
      '賣', '売', // 0x8ce3
      '賤', '賎', // 0x8ce4
      '贊', '賛', // 0x8d0a
      '赱', '走', // 0x8d71
      '踈', '疎', // 0x8e08
      '踴', '踊', // 0x8e34
      '躰', '体', // 0x8eb0
      '軆', '体', // 0x8ec6
      '軈', '軅', // 0x8ec8
      '軣', '轟', // 0x8ee3
      '輌', '輛', // 0x8f0c
      '輕', '軽', // 0x8f15
      '輙', '輒', // 0x8f19
      '轉', '転', // 0x8f49
      '辨', '弁', // 0x8fa8
      '辭', '辞', // 0x8fad
      '辯', '弁', // 0x8faf
      '迯', '逃', // 0x8fef
      '逎', '遒', // 0x900e
      '逹', '達', // 0x9039
      '遙', '遥', // 0x9059
      '遞', '逓', // 0x905e
      '遲', '遅', // 0x9072
      '邉', '辺', // 0x9089
      '邊', '辺', // 0x908a
      '邨', '村', // 0x90a8
      '鄰', '隣', // 0x9130
      '醉', '酔', // 0x9189
      '醫', '医', // 0x91ab
      '釀', '醸', // 0x91c0
      '釋', '釈', // 0x91cb
      '釡', '釜', // 0x91e1
      '釼', '剣', // 0x91fc
      '鈩', '鑪', // 0x9229
      '銕', '鉄', // 0x9295
      '錢', '銭', // 0x9322
      '鎭', '鎮', // 0x93ad
      '鐡', '鉄', // 0x9421
      '鐵', '鉄', // 0x9435
      '鑄', '鋳', // 0x9444
      '鑒', '鑑', // 0x9452
      '鑚', '鑽', // 0x945a
      '鑛', '鉱', // 0x945b
      '閇', '閉', // 0x9587
      '關', '関', // 0x95dc
      '阯', '址', // 0x962f
      '陷', '陥', // 0x9677
      '險', '険', // 0x96aa
      '隱', '隠', // 0x96b1
      '隸', '隷', // 0x96b8
      '雙', '双', // 0x96d9
      '雜', '雑', // 0x96dc
      '霸', '覇', // 0x9738
      '靈', '霊', // 0x9748
      '靜', '静', // 0x975c
      '靱', '靭', // 0x9771
      '韭', '韮', // 0x97ed
      '韲', '齏', // 0x97f2
      '韵', '韻', // 0x97f5
      '顏', '顔', // 0x984f
      '顯', '顕', // 0x986f
      '飃', '飄', // 0x98c3
      '飮', '飲', // 0x98ee
      '餘', '余', // 0x9918
      '餝', '飾', // 0x991d
      '餠', '餅', // 0x9920
      '騷', '騒', // 0x9a37
      '驅', '駆', // 0x9a45
      '驗', '験', // 0x9a57
      '驛', '駅', // 0x9a5b
      '髓', '髄', // 0x9ad3
      '體', '体', // 0x9ad4
      '髮', '髪', // 0x9aee
      '鬪', '闘', // 0x9b2a
      '鬱', '欝', // 0x9b31
      '鰛', '鰮', // 0x9c1b
      '鰺', '鯵', // 0x9c3a
      '鳫', '鴈', // 0x9ceb
      '鳬', '鳧', // 0x9cec
      '鵄', '鴟', // 0x9d44
      '鵞', '鵝', // 0x9d5e
      '鷄', '鶏', // 0x9dc4
      '鷏', '鷆', // 0x9dcf
      '鹽', '塩', // 0x9e7d
      '麥', '麦', // 0x9ea5
      '麪', '麺', // 0x9eaa
      '麸', '麩', // 0x9eb8
      '默', '黙', // 0x9ed8
      '點', '点', // 0x9ede
      '黨', '党', // 0x9ee8
      '鼡', '鼠', // 0x9f21
      '齊', '斉', // 0x9f4a
      '齋', '斎', // 0x9f4b
      '齒', '歯', // 0x9f52
      '齡', '齢', // 0x9f61
      '龜', '亀', // 0x9f9c
      '龝', '穐', // 0x9f9d
  };
  

  /** 異体字/普通字変換マップ */
  private static final Map<Character, Character> map;
  static {
    map = new HashMap<Character, Character>(TABLE.length / 2);
    for (int i = 0; i < TABLE.length; i += 2) {
      map.put(TABLE[i + 0], TABLE[i + 1]);
    }
  }


  /**
   * 指定された字を普通字に変換する。指定された字が異体字で無い場合はそのまま帰す。
   * @param input 変換対称の字
   * @return 変換された字、あるいはそのまま。
   */
  public static char convert(char input) {
    Character output = map.get(input);
    if (output != null) return output;
    return input;
  }
  
  /**
   * 指定された文字列の中の異体字をすべて普通字に変換した文字列を返す。
   * @param input 変換対称文字列
   * @return
   */
  public static String convert(String input) {
    char[]chars = input.toCharArray();
    for (int i = 0; i < chars.length; i++) {
      chars[i] = convert(chars[i]);
    }
    return new String(chars);
  }
}
