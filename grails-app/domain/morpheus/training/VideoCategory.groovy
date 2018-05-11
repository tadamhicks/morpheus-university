package morpheus.training

class VideoCategory {

	String videoCategoryName



    static constraints = {
    	videoCategoryName nullable: false
    }

    String toString() {
    	return videoCategoryName
    }
}
