USE [DLC_MotorDeBusqueda]
GO
/****** Object:  Table [dbo].[Posteo]    Script Date: 17/5/2018 15:25:48 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[Posteo](
	[termino] [varchar](50) NOT NULL,
	[documento] [varchar](50) NOT NULL,
	[tf] [int] NOT NULL,
 CONSTRAINT [PK_Posteo] PRIMARY KEY CLUSTERED 
(
	[termino] ASC,
	[documento] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
