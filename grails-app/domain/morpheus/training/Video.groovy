package morpheus.training

class Video {
	
	VideoCategory videoCategory
	String fileName
	String videoTitle
	String videoDescription

    static constraints = {
    	fileName nullable: false
    	videoTitle nullable: true
    	videoDescription nullable: true
    }
}
