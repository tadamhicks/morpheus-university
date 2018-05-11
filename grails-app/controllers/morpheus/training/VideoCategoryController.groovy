package morpheus.training

import static org.springframework.http.HttpStatus.*
import grails.transaction.Transactional

@Transactional(readOnly = true)
class VideoCategoryController {

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond VideoCategory.list(params), model:[videoCategoryCount: VideoCategory.count()]
    }

    def show(VideoCategory videoCategory) {
        respond videoCategory
    }

    def create() {
        respond new VideoCategory(params)
    }

    @Transactional
    def save(VideoCategory videoCategory) {
        if (videoCategory == null) {
            transactionStatus.setRollbackOnly()
            notFound()
            return
        }

        if (videoCategory.hasErrors()) {
            transactionStatus.setRollbackOnly()
            respond videoCategory.errors, view:'create'
            return
        }

        videoCategory.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'videoCategory.label', default: 'VideoCategory'), videoCategory.id])
                redirect videoCategory
            }
            '*' { respond videoCategory, [status: CREATED] }
        }
    }

    def edit(VideoCategory videoCategory) {
        respond videoCategory
    }

    @Transactional
    def update(VideoCategory videoCategory) {
        if (videoCategory == null) {
            transactionStatus.setRollbackOnly()
            notFound()
            return
        }

        if (videoCategory.hasErrors()) {
            transactionStatus.setRollbackOnly()
            respond videoCategory.errors, view:'edit'
            return
        }

        videoCategory.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'videoCategory.label', default: 'VideoCategory'), videoCategory.id])
                redirect videoCategory
            }
            '*'{ respond videoCategory, [status: OK] }
        }
    }

    @Transactional
    def delete(VideoCategory videoCategory) {

        if (videoCategory == null) {
            transactionStatus.setRollbackOnly()
            notFound()
            return
        }

        videoCategory.delete flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'videoCategory.label', default: 'VideoCategory'), videoCategory.id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'videoCategory.label', default: 'VideoCategory'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
