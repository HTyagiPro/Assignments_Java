USE [HarPro2308]
GO
/****** Object:  Table [dbo].[Account]    Script Date: 23-08-2023 12:33:03 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Account](
	[accId] [int] IDENTITY(1000,1) NOT NULL,
	[stdId] [int] NULL,
	[stdName] [varchar](20) NOT NULL,
	[accNo] [bigint] NULL,
	[accIfsc] [varchar](11) NULL,
	[recordCreatedOn] [datetime] NULL,
PRIMARY KEY CLUSTERED 
(
	[accId] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Fee]    Script Date: 23-08-2023 12:33:04 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Fee](
	[feeRecieptNo] [int] IDENTITY(10000,1) NOT NULL,
	[accId] [int] NULL,
	[feeAmount] [money] NULL,
	[monthForFee] [varchar](10) NULL,
	[creditedOn] [smalldatetime] NULL,
PRIMARY KEY CLUSTERED 
(
	[feeRecieptNo] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[StdFeeRecord]    Script Date: 23-08-2023 12:33:04 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[StdFeeRecord](
	[stdId] [int] IDENTITY(100,1) NOT NULL,
	[stdName] [varchar](20) NOT NULL,
	[feeRecieptNo] [int] NOT NULL,
	[dob] [date] NULL,
	[recordCreatedOn] [datetimeoffset](7) NULL,
	[rowVersion] [timestamp] NOT NULL,
PRIMARY KEY CLUSTERED 
(
	[stdId] ASC,
	[stdName] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
SET IDENTITY_INSERT [dbo].[Account] ON 

INSERT [dbo].[Account] ([accId], [stdId], [stdName], [accNo], [accIfsc], [recordCreatedOn]) VALUES (1000, 100, N'Ajay', 123456, N'bkid3001', CAST(N'2023-08-23T09:44:24.917' AS DateTime))
INSERT [dbo].[Account] ([accId], [stdId], [stdName], [accNo], [accIfsc], [recordCreatedOn]) VALUES (1001, 100, N'Ajay', 987323, N'bkid3001', CAST(N'2023-08-23T09:44:24.917' AS DateTime))
INSERT [dbo].[Account] ([accId], [stdId], [stdName], [accNo], [accIfsc], [recordCreatedOn]) VALUES (1002, 101, N'Prolifics', 456123, N'bkid3001', CAST(N'2023-08-23T09:44:30.937' AS DateTime))
SET IDENTITY_INSERT [dbo].[Account] OFF
GO
SET IDENTITY_INSERT [dbo].[Fee] ON 

INSERT [dbo].[Fee] ([feeRecieptNo], [accId], [feeAmount], [monthForFee], [creditedOn]) VALUES (10000, 1001, 6200.0000, N'Jan', CAST(N'2023-08-23T09:45:00' AS SmallDateTime))
INSERT [dbo].[Fee] ([feeRecieptNo], [accId], [feeAmount], [monthForFee], [creditedOn]) VALUES (10001, 1002, 6200.0000, N'Feb', CAST(N'2023-08-23T09:45:00' AS SmallDateTime))
INSERT [dbo].[Fee] ([feeRecieptNo], [accId], [feeAmount], [monthForFee], [creditedOn]) VALUES (10002, 1002, 6200.0000, N'Jan', CAST(N'2023-08-23T09:45:00' AS SmallDateTime))
INSERT [dbo].[Fee] ([feeRecieptNo], [accId], [feeAmount], [monthForFee], [creditedOn]) VALUES (10003, 1002, 6200.0000, N'Jan', CAST(N'2023-08-23T12:14:00' AS SmallDateTime))
INSERT [dbo].[Fee] ([feeRecieptNo], [accId], [feeAmount], [monthForFee], [creditedOn]) VALUES (10004, 1002, 6200.0000, N'Jan', CAST(N'2023-08-23T12:14:00' AS SmallDateTime))
SET IDENTITY_INSERT [dbo].[Fee] OFF
GO
SET IDENTITY_INSERT [dbo].[StdFeeRecord] ON 

INSERT [dbo].[StdFeeRecord] ([stdId], [stdName], [feeRecieptNo], [dob], [recordCreatedOn]) VALUES (100, N'Ajay', 1001, CAST(N'2002-01-30' AS Date), CAST(N'2023-08-23T09:43:03.9862416+05:30' AS DateTimeOffset))
INSERT [dbo].[StdFeeRecord] ([stdId], [stdName], [feeRecieptNo], [dob], [recordCreatedOn]) VALUES (101, N'Prolifics', 1002, CAST(N'2023-08-23' AS Date), CAST(N'2023-08-23T09:43:48.5153093+05:30' AS DateTimeOffset))
INSERT [dbo].[StdFeeRecord] ([stdId], [stdName], [feeRecieptNo], [dob], [recordCreatedOn]) VALUES (104, N'Vijay', 1003, CAST(N'2002-12-30' AS Date), CAST(N'2023-08-23T09:48:50.8259142+05:30' AS DateTimeOffset))
INSERT [dbo].[StdFeeRecord] ([stdId], [stdName], [feeRecieptNo], [dob], [recordCreatedOn]) VALUES (105, N'Sanjay', 1004, CAST(N'2002-05-30' AS Date), CAST(N'2023-08-23T09:49:18.3438894+05:30' AS DateTimeOffset))
INSERT [dbo].[StdFeeRecord] ([stdId], [stdName], [feeRecieptNo], [dob], [recordCreatedOn]) VALUES (106, N'Cheeko', 1005, CAST(N'2023-08-23' AS Date), CAST(N'2023-08-23T09:49:32.0146156+05:30' AS DateTimeOffset))
INSERT [dbo].[StdFeeRecord] ([stdId], [stdName], [feeRecieptNo], [dob], [recordCreatedOn]) VALUES (107, N'Prolifics', 1006, CAST(N'2023-08-23' AS Date), CAST(N'2023-08-23T09:49:38.8297530+05:30' AS DateTimeOffset))
INSERT [dbo].[StdFeeRecord] ([stdId], [stdName], [feeRecieptNo], [dob], [recordCreatedOn]) VALUES (108, N'Prolifics', 1007, CAST(N'2023-08-23' AS Date), CAST(N'2023-08-23T09:49:48.4368513+05:30' AS DateTimeOffset))
SET IDENTITY_INSERT [dbo].[StdFeeRecord] OFF
GO
/****** Object:  Index [UQ__Account__A471970498FFF15C]    Script Date: 23-08-2023 12:33:04 ******/
ALTER TABLE [dbo].[Account] ADD UNIQUE NONCLUSTERED 
(
	[accNo] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, SORT_IN_TEMPDB = OFF, IGNORE_DUP_KEY = OFF, ONLINE = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
GO
/****** Object:  Index [UQ__StdFeeRe__30B15EFEE30A529D]    Script Date: 23-08-2023 12:33:04 ******/
ALTER TABLE [dbo].[StdFeeRecord] ADD UNIQUE NONCLUSTERED 
(
	[feeRecieptNo] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, SORT_IN_TEMPDB = OFF, IGNORE_DUP_KEY = OFF, ONLINE = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
GO
ALTER TABLE [dbo].[Account] ADD  DEFAULT ('Prolifics') FOR [stdName]
GO
ALTER TABLE [dbo].[Fee] ADD  DEFAULT ((6200)) FOR [feeAmount]
GO
ALTER TABLE [dbo].[StdFeeRecord] ADD  DEFAULT ('Prolifics') FOR [stdName]
GO
ALTER TABLE [dbo].[StdFeeRecord] ADD  DEFAULT (getdate()) FOR [dob]
GO
ALTER TABLE [dbo].[Account]  WITH CHECK ADD  CONSTRAINT [link] FOREIGN KEY([stdId], [stdName])
REFERENCES [dbo].[StdFeeRecord] ([stdId], [stdName])
GO
ALTER TABLE [dbo].[Account] CHECK CONSTRAINT [link]
GO
ALTER TABLE [dbo].[Fee]  WITH CHECK ADD FOREIGN KEY([accId])
REFERENCES [dbo].[Account] ([accId])
GO
ALTER TABLE [dbo].[Fee]  WITH CHECK ADD CHECK  (([feeAmount]>(5000)))
GO
