CREATE TABLE `member` (
                          `id`	        varchar(16)	    NOT NULL comment '아이디',
                          `password`	varchar(255)	NULL comment '비밀번호',
                          `name`	    varchar(30)	    NULL comment '이름',
                          `input_date`	date	        NULL comment '등록일',
                          `email`	    varchar(40)	    NULL comment '이메일',
                          `join_type`	int	            NULL,
                          PRIMARY KEY( 'id' )
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `chatting_room` (
                            `pk`	        varchar(36)	NOT NULL comment '채팅방 PK',
                            `title`	        varchar(255)NULL comment '채팅방 이름',
                            `type`	        int	        NULL comment '채팅방 타입',
                            `input_date`	date	    NULL comment '등록일',
                            `input_user`	varchar(16)	NULL comment '등록자',
                            `mod_date`	    date	    NULL comment '수정일',
                            `mod_user`	    varchar(16)	NULL comment '수정자',
                            `del_date`	    date	    NULL comment '삭제일',
                            PRIMARY KEY( 'pk' )
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE 'chatting' (
	                        `mpk`	        varchar(36)	NOT NULL  comment '채팅 PK',
	                        `pk`	        varchar(36)	NOT NULL  comment '채팅방 PK',
	                        `message`	    varchar(255)	NULL  comment '메시지',
	                        `input_date`    date	NULL          comment '등록일',
	                        `input_user`    varchar(16)	NULL        comment '등록자',
	                        `mod_date`	    date	NULL     comment '수정일',
	                        `mod_user`  	varchar(16)	NULL     comment '수정자',
	                        `del_date`	    date	NULL  comment '삭제일',
	                        `message_flag`	int	NULL  comment '채팅 타입',
                            PRIMARY KEY( 'mpk' )
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `user_chatting_group` (
	`gpk`	varchar(36)	NOT NULL comment '채팅 그룹 PK',
	`id`	varchar(16)	NOT NULL comment '채팅 유저 PK',
	`pk`	varchar(36)	NOT NULL comment '채팅방 PK',
    PRIMARY KEY( 'gpk' )

) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `file` (
	`pk`	varchar(36)	NOT NULL comment '파일 PK',
	`target_pk`	varchar(36)	NULL comment '파일 Target PK',
	`target_type`	int	NULL comment '파일 Target 타입',
	`file_name`	varchar(255)	NULL comment '파일 이름',
	`ext`	varchar(5)	NULL comment '파일 확장자',
    PRIMARY KEY( 'pk' )
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

